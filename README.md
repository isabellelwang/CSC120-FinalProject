# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

REFLECTION:
 My overall approach of tackling this project was to do every part a little bit at once and figure out my way as I go. This approach isn't the most effective, and I found that having a solid base diagram and understanding of how my game will work is necessary. While constructing the classes, I found that building the GamePlay at the same time helped with understanding what methods I would need and not need. 

 From this project, I learned how that it is not legal in Java to have 2D arrays of data type ArrayList. I also learned about the importance of giving clear directions of the game and what users can do. Initially, I had little instructions, and I found adding descriptions like "Press enter to continue" made the game easier to play for users. On Demo day, I noticed how I was explaining the game to people in real-life rather than the game explaining what it can do through a help option. I also found how helpful to add error exceptions like when users type a number over than 3, that could possibly crash the program. 

Something I wished to implement differently was for necklace, eel, and fish to spawn at random, but different coordinates. At first, I wasn't sure how I could keep on generating a coordinate where it will check to see if the coordinate was taken, so I setioned four different points for each NPC. Like an eel would be in one of four coordinates, and so on. But after Demo day, I decided to try different algorithms that could check whether a coordinate is taken to allow a more randomized location for the NPCs. Another thing i wished I implemented differently was storing the fishing pole and boat. There were many options for me to access fishing pole and boat and add it to the game that it confused me on how I should call for them. 

One thing I wish to implement is to have difficulty levels that users could choose and it would affect the number of eels/fish and size of ocean. I also wished I could try to add graphics where the screen would pop up with the game title and list some basic rules/game objectives. 

 I received lots of helpful feedback from different people that helped me build the game and make it more engaging. Prof. Johanna taught me that having Arraylist within 2D arrays are not legal. When Prof. Jordan tried my game during demo day, I got the idea to have multiple outcomes when the user enters jump off boat. YuZhang Fu recommended that users can type in the word for input rather than the number options, which I learned to do from Dani Justo's switch-case program. 

 If I could go back in time, I would tell myself to first have a solid plan of what I wanted to make before jumping into action. My ideas were all very dispersed and it wasn't very clear how I wanted the game to run. I knew the basic storyline, but I wasn't sure if I wanted to add trivia questions or let users row boat and find the necklace. 


 JUSTIFICATION:
 One alternative I wanted to use was to generate trivia questions that users can answer that would help them win the game. Rather than having users row boat and move by units, I was planning on having users move by x units if they answered a trivia question correctly. However, I decided against this and opted for a game where users can move themselves because I think the game may become repetitive after certain number of rounds when the trivia questions are being recycled through. 

 Another design feature was for users to be have independent outcomes for the catch item and extend fishing pole. Currently, the catch option requires users to extend first. I originally planned extend fishing pole to extend and change the fishing pole coordinates and catchItem to rewind the fishing pole and print out if user caught something. However, I thought it would be quicker if users would be able to know if they caught something after they extended, so the extend pole is merged with catch item. 

 
