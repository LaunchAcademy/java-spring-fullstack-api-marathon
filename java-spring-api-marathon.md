## Getting Started

```no-highlight
et get java-spring-api-marathon
cd java-spring-api-marathon
createdb my_sweet_tunes_development
idea .
```

**Once you have completed steps 1 & 2, the provided code should compile and you can run:**

```no-highlight
./mvnw spring-boot:run
```

In a second tab:

```no-highlight
cd src/main/frontend
yarn run dev:client
```

## For those about to Rock

With all this coding we're doing, we need some good background music! Let's use your Java skills to find a better way to keep track of our favorites.

Take a look at the provided migration, entity, and React frontend before getting started with the below.

### List the Artists

```no-highlight
As a music fan
I want to see a listing of all artists
So that I can keep track of my favorites
```

Acceptance Criteria:

- When a user navigates to `/artists`, they should see a list of artists.
- The name of each artist should be a link to the show page for the artist, at `/artists/:id`.

Implementation Details:

- You've been provided with an `ArtistsSeeder` file with some artist data. Once the necessary classes and interfaces have been created, boot up your Spring Boot server and this data will be populated for you.

1. Take a look at the `ArtistsSeeder` and notice all those classes and methods that don't yet exist. Let's write some code to fix that! Create an `ArtistsRepository` interface, an `ArtistService` interface, and an `ArtistDatabaseService` class that utilizes the `ArtistsRepository`.
2. Now let's take care of those methods that are erroring out! You will need to create `findAll`, `findById`, and `save` methods. After this you should be able to start up your server which will run the seeder.
3. Create an `ArtistsApiV1Controller` that utilizes the `ArtistService`. Create the API endpoint at `/api/v1/artists` to serve up the proper artist data to the frontend.

### Create Your Artists via Web Form

```
As a musician
I want to add myself to the list of artists
So I can start sharing my music with the world
```

Acceptance Criteria:

- When a user navigates to `/artists/new` they should see a form to add a new artist.
- Submitting your form successfully redirects the user back to the artists index page, where they see the newly added artist listed.
- If the form is not filled out correctly, the new artist should not be persisted and the user should remain on the form page

Implementation Details:

4. Create a `@PostMapping` API endpoint to persist user input, handling for the "happy path" only.
5. Once the happy path is working, set up your controller to return a generic error if the artist cannot be created, using the provided `ArtistNotCreatedException` class.

### Viewing an Artist

```no-highlight
As a music fan
I want to see the details about an artist
So I can remember my favorite songs by them
```

Acceptance Criteria:

- When a user navigates to `/artists/:id`, they should see the name of the artist with that `id`.
- There should also be a list of all the `songs` related to that specific menu.

Implementation Details:

- You have been provided with a `Song` entity and a migration for the songs table.

6. Create the API endpoint at `/api/v1/artists/{id}` to serve up the proper artist data to the frontend. _Your frontend will not work until you have completed step 7._
7. Take the necessary steps to associate the `Artist` and `Song` entities.
8. Add a custom `findByName` method to your `ArtistRepository`, and the corresponding necessary methods to your services, so that the seeder may use it. Now, comment in the contents of the `seed()` method in the provided `SongsSeeder`, and double-check in the browser to make sure the associated `songs` data is coming through the endpoint.
9. Add error handling to the "show" endpoint so that the fetch request results in a 404 if the artist is not found. You may use the provided `ArtistNotFoundException` class to throw an error.

### Adding Songs

```no-highlight
As a musician
I want to share my songs with the world
So I can teach the world to rock
```

Acceptance Criteria:

- When a user navigates to `/artists/:id/songs/new`, they should see a form to add a new song for the artist
- Submitting your form successfully redirects the user back to the artist's show page, where they see the newly added song listed.
- If the form is not filled out correctly, the new song should not be persisted and the user should remain on the form page

10. We're going to create a `@PostMapping` API endpoint for `/api/v1/songs` to persist user input. After creating this endpoint, create a `SongForm` to take in all attributes for a song along with an `artistId`. Add this `SongForm` to the endpoint so the body of the POST request is mapped to it.

11. In this endpoint, use the `SongForm` to associate a song with a particular artist. Remember to add any necessary methods in your `SongService` as well to persist this new song. Once the happy path is working, set up your controller to return a generic error if the song cannot be created, using the provided `SongNotCreatedException` class.
