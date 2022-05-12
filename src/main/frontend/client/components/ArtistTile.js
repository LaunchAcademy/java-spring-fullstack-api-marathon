import React from "react"
import { Link } from "react-router-dom"

const ArtistTile = props => {
  const { id, name } = props.artist

  return (
    <div>
      <Link to={`/artists/${id}`}>
        <h1>{name}</h1>
      </Link>
    </div>
  )
}

export default ArtistTile
