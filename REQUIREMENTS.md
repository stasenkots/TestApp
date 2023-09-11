__Requirements__:

1. The app should have a login screen where users can enter their credentials (username and password) to authenticate. 
2. Implement a mock login functionality that accepts any non-empty username and password combination for successful login.
3. After successful login, navigate the user to a home screen that displays a welcome message with the user's name.
4. Implement a logout functionality that allows the user to log out from the app and navigate back to the login screen.
5. On the home screen, display a list of posts retrieved from a mock API.
6. For the posts list you need to show the username associated with that post along with the title, description, and post image, for the image you can use the provided mock API. 
7. Implement pagination to load more posts as the user scrolls down the list.
8. Provide a search functionality to filter the posts based on the mock API.
9. Allow users to select a post from the list to view its details on a separate screen. On the post details screen, include additional information related to the user, such as the user’s full name, email, phone number, username, gender, dob, and profile image].
10. Implement a logger for the user actions, such as login, search, selecting a post from the list, and page changes, and storing that in-app storage. As you have the interaction logs for each user session (app open/resume to background/close) send that as a JSON Array (raw data) in the provided mock API.
11. Write unit tests for the ViewModel and Repository layers using TDD principles.
