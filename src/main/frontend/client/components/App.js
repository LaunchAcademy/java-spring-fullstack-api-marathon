import React, { useEffect } from "react"
import { hot } from "react-hot-loader/root"
import "foundation-sites"
import $ from "jquery"
import "../assets/scss/main.scss"

import { Route, BrowserRouter, Switch, Redirect } from "react-router-dom"

import ArtistsIndex from "./ArtistsIndex"
import ArtistShow from "./ArtistShow"
import NewSongForm from "./NewSongForm"
import NewArtistForm from "./NewArtistForm"

const App = props => {
  useEffect(() => {
    $(document).foundation()
  }, [])

  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Redirect to="/artists" />
        </Route>
        <Route exact path="/artists" component={ArtistsIndex} />
        <Route exact path="/artists/new" component={NewArtistForm} />
        <Route exact path="/artists/:id/songs/new" component={NewSongForm} />
        <Route exact path="/artists/:id" component={ArtistShow} />
      </Switch>
    </BrowserRouter>
  )
}

export default hot(App)
