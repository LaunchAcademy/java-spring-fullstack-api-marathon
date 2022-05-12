import React, { useState } from "react"
import { Redirect } from "react-router"
import { Link } from "react-router-dom"
import _ from "lodash"

import ErrorList from "./ErrorList"

const NewSongForm = props => {
  const [formPayload, setFormPayload] = useState({
    title: "",
    genre: "",
    releaseYear: null,
    explicitContent: false
  })
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const addSong = async () => {
    const artistId = props.match.params.id
    formPayload.artistId = artistId
    try {
      const response = await fetch(`/api/v1/songs`, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json()
          return setErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw error
        }
      }

      const body = await response.json()
      setShouldRedirect(true)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const handleSubmit = event => {
    event.preventDefault()
    addSong()
  }

  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  if (shouldRedirect) {
    return <Redirect push to={`/artists/${props.match.params.id}`} />
  }

  return (
    <div>
      <h1>Add a new song to the artist!</h1>
      <Link to={"/artists"}>Back to artists</Link>
      <form className="callout" onSubmit={handleSubmit}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="title">Title: </label>
          <input
            name="title"
            id="title"
            type="text"
            value={formPayload.title}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="genre">Genre: </label>
          <input
            name="genre"
            id="genre"
            type="text"
            value={formPayload.genre}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="releaseYear">Release Year: </label>
          <input
            name="releaseYear"
            id="releaseYear"
            type="number"
            value={formPayload.releaseYear}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="explicitContent">Explicit Content: </label>
          <input
            name="explicitContent"
            id="explicitContent"
            type="checkbox"
            value={formPayload.explicitContent}
            onChange={handleInputChange}
          />
        </div>

        <input className="button" type="submit" value="Submit" />
      </form>
    </div>
  )
}

export default NewSongForm
