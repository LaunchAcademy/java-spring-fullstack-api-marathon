import React, { useEffect, useState } from "react"
import { useLocation, Link } from "react-router-dom"

import SongsTile from "./SongTile"

const ArtistShow = props => {
  let location = useLocation()
  const [artist, setArtist] = useState({ songs: [] })
  const artistId = props.match.params.id

  const fetchArtist = async () => {
    try {
      const response = await fetch(`/api/v1/artists/${artistId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setArtist(responseBody.artist)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchArtist()
  }, [location.pathname])

  const songTiles = artist.songs.map(song => {
    return <SongsTile key={song.id} song={song} />
  })

  return (
    <div>
      <h1>{artist.name}</h1>
      <Link to={"/artists"}>Back to artists</Link> |{" "}
      <Link to={`/artists/${artistId}/songs/new`}>Add a new song to the artist!</Link>
      <h2>Songs by this Artist</h2>
      <ul>{songTiles}</ul>
    </div>
  )
}

export default ArtistShow
