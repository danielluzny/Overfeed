# Architecture  


### Iteration 1 Diagram  

![Architecture](ArchitectureIteration1.png)  

### Presentation Layer  
- [Main Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/presentation/MainActivity.java)  
  - The file for the screen launched at the start of the app as well as the view where majority of the game will take place  

- [Statistics Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/presentation/StatisticsActivity.java)  
  - The file for the view of the statistics in the game  

### Logic Layer  
- [Meal Logic](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/logic/MealLogic.java)  
  - The class that handles all Meal related logic. This includes methods needed for setting meals, getting clicks, etc.  

- [Save Logic](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/logic/SaveLogic.java)  
  - The class that handles all Save related logic such as methods needed for saving and loading the game.   

- [Time Logic](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/logic/TimeLogic.java)  
  - The class that deals with Time related logic such as methods for getting time and formatting time.   

### Persistence Layer  
- [Meal Persistence](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/persistence/MealPersistence.java)  
  - The class that deals with Meal related objects in the "database"  

- [Save Persistence](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/persistence/SavePersistence.java)  
  - The class that deals with Save related objects in the "database"

- [Time Persistence](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/blob/master/app/src/main/java/comp3350/overfeed/persistence/TimePersistence.java)  
  - The class that deals with Time related objects in the "database"  


### Domain Specific Objects   
- For Iteration 1, we did not find any use for Domain Specific Objects with the functions that we have implemented. We will add them in our next iterations.  
