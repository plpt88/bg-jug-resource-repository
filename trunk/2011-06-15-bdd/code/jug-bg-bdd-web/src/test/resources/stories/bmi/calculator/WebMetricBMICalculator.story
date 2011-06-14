Meta:
@author          Nikolay Vasilev
@date:           15.06.2011
@event:          Seminar
@topic:          Behaviour Driven Development with Java
@organization:   Bulgarian Java Users Group
@licence:        Some rights reserved. CC BY 3.0, 2011

Scenario: User opens BMI Calculator main page
Given an user is on the BMI Calculator main page
Then the BMI Calculator main page should be displayed

Scenario: User opens BMI Calculator performs successfull request
Given an user is on the BMI Calculator main page
When the user populates the form with values for mass - <mass> kg and height - <height> m
And the user clicks on the Calculate button
Then the user is brought to BMI Result Analysis page 
And user's body mass index is <bmi>
And user's weight category is <weight-category>

Examples:
|mass		|height		|bmi					|weight-category		|
|50			|1.99		|12.625944137573242		|Severely Underweight	|
|50			|1.70		|17.301036834716797		|Underweight			|
|75			|1.75		|24.489795684814453		|Normal					|
|83			|1.77		|26.493024826049805		|Overweight				|
|115		|1.95		|30.24325942993164		|Obese Class I			|
|115		|1.75		|37.551021575927734		|Obese Class II			|
|115		|1.55		|47.86680603027344		|Obese Class III		|

Scenario: User populates only mass value and BMI calculation request fails

Given an user is on the BMI Calculator main page
When the user populates the form only with value for mass 80 kg
And the user clicks on the Calculate button
Then the user is brought back to BMI Calculator main page
And an error message is displayed: Problem during BMI calculation.

Scenario: User populates only height value and BMI calculation request fails

Given an user is on the BMI Calculator main page
When the user populates the form only with value for height 1.95 m
And the user clicks on the Calculate button
Then the user is brought back to BMI Calculator main page
And an error message is displayed: Problem during BMI calculation.
