# UserDataUtil
Project for DSA 
What dataset do you analyze? Are there multiple tables? For each table, answer what are the rows and what are the columns.
I used Mockaroo to create 1000 rows of fake user data, each row is a user.  There is only one table, and the columns are as follows: Username, Password, First Name, Last Name, Email, Phone, DOB, Gender, Address.
What questions is your software meant to answer on your dataset?
I started with the idea of checking if usernames appeared in passwords and then expanded to being able to search and sort the data set by, username, last name and email. I got curious about the timing and wanted to set myself up for expanding the search and sort algorithms used, so last I added timing functionality to all the menu calls.
What algorithms and data structures did you use?
I used the built in Java .sort() which I believe is quicksort, I planned on integrating some more complex search algorithms and adjusting the data set to do real science but ran out of time so sort is just linear and binary. ArrayList was the main data structure used to store and manage the list of users. 
What is their time and space complexity using big oh notation?
Quicksort used for sorting should be O(n log n), Linear search is O(n) and Binary search is O(log n) but only if the list is sorted so I realize I should have added some error handling for this case.
How can someone test your code? For example, what are some example inputs and the corresponding output you expect.
I specifically set this up for testing, learning, and expansion, testing requires looking at the data set, then comparing results from the program run to see if it in fact did its job, the built-in time checking will allow for comparison testing between algorithms in a future version.
Consider what the command-line interface would be, or API requests and responses if you have a website.
I started this with the goal of using JavaFX to build a GUI, I’ve had success with it before but got frustrated and decided just to use the console. If I were to expand the project I would want to be able to add data to the set so the API would have GET and SET, I need to learn more about API’s I touched on it this quarter and know I need to learn more. I think my menu illustrates my goals for the project even though it may be a bit broken.
What challenges did you encounter and how did you solve them?
The first challenge was JavaFX, I went with a simpler option, second obstacle was learning about parsing the csv file, this just took some experimenting and eventually I managed to clean the dataset enough to work. A big problem was the changing of scope and I had to just tone everything down to a level I understood to get it to work, I did some testing and everything seemed to be working but I didn’t test a ton of edge cases and I’m also not sure about my version control so I would have been more careful to keep versions in the future.
What programming languages, frameworks, or technologies did you use?
I just used basic Java, I wanted to use JavaFX for a GUI but ran out of time. I used Mockaroo to generate data with AI.
Who are your teammates, if any?
I worked on this alone over the break.
