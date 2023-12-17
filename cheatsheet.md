This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

Contains two types of NPCs: 
Eel- automatically lose
Fish- Gives a hint of the x or y coordinate of the necklace 

Options include: 
- row boat : rows the boat up to 2 units at a time, either horizontally or vertically. If the coordinate is at (0, 0), the direction is automatically set to positive x and y. Otherwise users can choose to move right/left and up/down. 
- get on boat: prints out user is already on the boat.
- jump off boat: Four results that is randomly generated using Math.random(). All results lead to an automatic lose though.
- extend fishing pole: extends the fishing pole up to 3 units, either horizontally or vertically. If coordinate is at (0,0), the direction is automatically set to the positive x and y; otherwise, users can choose to move right/left and up/down. After choosing the coordinates, the extended coordinate is compared with fish, eel, and necklace to see if user caught something. 
- catch item: tells user to extend pole first
- swim: tells users to jump off the boat first
- print my coordinates: Prints out user's current coordinates
- how to play: prints out rules/game objective


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

The placement of the eel, fish, and necklace is set into four squares. 


