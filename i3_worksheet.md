What technical debt has been cleaned up
========================================

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.

Shortly after Iteration 2 was finished, we went back and refactored a large majority
of our classes, such as MealLogic, in order to make things both more visually easier
to read (code-wise), as well to clear up some dependencies between the layers. 

Links: 
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/commit/4fb0c0d5cefd68c46998aefbf91573db548a8bdb
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/commit/d7c7ae4b3cf8fa51d4836d885ca3106cc7d11e22


What technical debt did you leave?
==================================

What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.

One thing that our team really struggled with was the pick of Android Studio
to create our app. In order to pass data around between our various classes,
we needed to implement Serializable in almost all of our classes. This was not
an easy task to complete, and was not truly condusive to our use in this project.
We would have liked to have some other IDE/app creation method, or more specifically
some way to pass data between classes that does not implement Serializable. This
debt could be classified as Prudent Deliberate - we knew that this would be technical
debt, and we made the choice to continue using it.


Discuss a Feature or User Story that was cut/re-prioritized
============================================

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.

Early on at the start of Iteration 2, we decided to move the Random Events feature
from Iteration 2, to Iteration 3. We then later still decided to move the feature 
into the "Future" milestone. We chose to reprioritize this feature given that it 
was additional, and not essential to the core game itself, we could push it further
back with little problem. We then later decided to push it again, both times in order
to focus on the polish and needed features. This would be a nice additional feature
to have in the eventuality, but it was not necessary to have at this moment, and thus
we safely moved it to the "Future" milestone. 

Link: https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/13


Acceptance test/end-to-end
==========================

Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.

The upgrades system test was the most complex of the ones we wrote. It began by performing clicks in a loop up to a certain number of meals created, then navigated to the upgrades page to purchase an upgrade. It then moved back to the main page, clicked a number of times, and navigated to the upgrades page to purchase an automated upgrade (Workers). Finally, it navigated back to the main page and waited for a number of second to pass, then asserted that the meals-per-second matches with what the upgrade provides. 

To be frank, we're not entirely sure the test *isn't* flaky. It depends on time as a variable and there may be problems with the computer running the test. It's possible there is a "jump" or "skip" that happens if the machine running it is slow or has some other background process running.

Acceptance test, untestable
===============

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?

When creating the feature of background music, there was not really any way to write an automated 
acceptance test that would be able to hear that music and ambience had been added. Other than
that, most of our project could feasibly be tested.

https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/blob/master/app/src/androidTest/java/comp3350/overfeed/UpgradesTest.java


Velocity/teamwork
=================

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.

Overall, our estimates were accurate except for on one major feature: saving. We were unable to 
complete this feature until the third iteration. It became a large project that ended up taking 
most of our time for the remaining iterations, and far more time than any other feature of
our project. 

Links: 
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/7
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/6
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/2

As you can see from the edit history of each of these issues, we continued to move the saving
feature and its user stories, from starting it in Iteration 1, pushing it to Iteration 2, and 
finally finishing it in Iteration 3. Aside from saving, our other features we estimated very
accurately.

Links: 
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/19
https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-8-overfeed-the-world/-/issues/17

