# PostApp

Using the API endpoint
- GET http://jsonplaceholder.typicode.com/posts
- GET http://jsonplaceholder.typicode.com/users
- GET http://jsonplaceholder.typicode.com/comments

Create a simple Android app with two screens:
- Screen1: A screen containing a list of posts
    - a title
    - a list view. Tapping a cell should take you to Screen2; each cell displaying:
        - post title

- Screen2: The detail screen for the selected post. Back button should take you back to screen 1
    - title
    - labels for the fields:
        - post title
        - post body
        - user name
        - number of comments

Bonus:
- Based on the user’s email address, use http://avatars.adorable.io to generate a unique
avatar for each of the contacts. To be shown on both screens.
