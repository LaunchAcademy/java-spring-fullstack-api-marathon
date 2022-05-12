import React from "react"

const SongTile = ({ song: { title, releaseYear } }) => {
  return (
    <li>
      {title}, {releaseYear}
    </li>
  )
}

export default SongTile
