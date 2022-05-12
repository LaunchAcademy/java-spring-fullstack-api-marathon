import React, { useState } from "react"
import { Redirect } from "react-router"
import { Link } from "react-router-dom"
import _ from "lodash"

import ErrorList from "./ErrorList"

const NewArtistForm = props => {
  const [formPayload, setFormPayload] = useState({
    name: ""
  })
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const addArtist = async () => {
    try {
      const response = await fetch(`/api/v1/artists`, {
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
    addArtist()
  }

  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  if (shouldRedirect) {
    return <Redirect push to={`/artists`} />
  }

  return (
    <div>
      <h1>Add a new Artist</h1>
      <Link to={"/artists"}>Back to artists</Link>
      <form className="callout" onSubmit={handleSubmit}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">Name: </label>
          <input
            name="name"
            id="name"
            type="text"
            value={formPayload.name}
            onChange={handleInputChange}
          />
        </div>

        <input className="button" type="submit" value="Submit" />
      </form>
    </div>
  )
}

export default NewArtistForm
