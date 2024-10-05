# Movie Listing Application

## Project Overview

The **Movie Listing Application** is a simple Java console-based application that allows users to:
- Register with their email address.
- Search for movies by title, cast, or category.
- View detailed information about a movie.
- Add or remove movies to/from their favorites.
- View and search within their list of favorite movies.
- View personal details, including their email and the movies they have added to their favorites.

The application uses a `HashSet` to manage the user's favorite movies, ensuring there are no duplicate entries. It also performs validation checks on email input to ensure only properly formatted emails are accepted.

---

## Features

1. **User Registration**
   - Users can register with a valid email address.
   - The application continuously prompts the user for a valid email if the format is incorrect.

2. **Movie Search**
   - Users can search for movies by entering a keyword that matches the title, cast, or category.
   - Movies are displayed in ascending order by title.

3. **Movie Details**
   - Users can view details of any movie, including the title, cast, category, release date, and budget.

4. **Favorites Management**
   - Users can add movies to their favorites list (no duplicates allowed).
   - Users can remove movies from their favorites list.
   - The list of favorite movies can be searched, filtered, and displayed.

5. **User Personal Details**
   - Users can view their registered email and the movies they have added to their favorites.

---
