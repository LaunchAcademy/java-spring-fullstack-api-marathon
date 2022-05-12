import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"

import ArtistTile from "./ArtistTile"

const ArtistsIndex = props => {
  const [artists, setArtists] = useState([])

  const fetchArtists = async () => {
    try {
      const response = await fetch("/api/v1/artists")
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setArtists(responseBody.artists)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchArtists()
  }, [])

  const artistTiles = artists.map(artist => {
    return <ArtistTile key={artist.id} artist={artist} />
  })

  return (
    <div>
      <Link to={"/artists/new"}>Add a new Artist</Link>
      {artistTiles}
    </div>
  )
}

export default ArtistsIndex
