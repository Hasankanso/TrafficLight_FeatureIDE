# TrafficLightFeatureIDE
this is a demonstration on how to use feature IDE on eclipse, refining classes based on activated features, composing features based on feature selection,

# Prepare
1. Install eclipse
2. Make sure to have FeatureIDE plugin (in my case I used version 3.6.3) installed in eclipse. To install FeatureIDE click on Help in upper menu bar, then Eclipse Marketplace and search for FeatureIDE

# Project Description
This project itself is not useful in any field, it is a demonstration on how to use FeatureIDE. The idea of the project is a road intersection with traffic lights. The base project has only two roads/directions: left and right roads. In the runtime you can add vehicles to roads(or add pedestrians if activated) and then you can update time to let vehicles(and pedestrians) cross the intersections. When a vehicle leave the left road as example, it does not go the right road, instead it disappears. With time the traffic lights will get updated, letting vehicles/pedestrians leave the road or force them to wait for the green light.

# Technical Description
There's two traffic light strategies: 
1. Timed Strategy: every 10 steps, the green lighted roads will turn red and the red will turn green, and the cycle goes like that until the end.
2. OnDemand Strategy: this strategy is more complicated, the left and right roads are per default green, they only change their states in one case: if a pedestrian on left/right roads or vehicles on top/bottom roads were added. Then lights will switch states for 10 steps. After the 10 steps, the light states will get back to the default states(green on left/right roads, and red on top/bottom) for at least for another 10 steps, after that the cycle restart(just read the beginning of the strategy description again).

It's possible to activate orange light feature, which makes switching between light states takes 2 extra steps. (red -> orange -> orange -> green)

Only one vehicle/pedestrian per road can leave at a time.  
# RUN

Open the project in eclipse and pick whatever features you want from model.xml, you pick features through ticking correspondent checkboxes.
After choosing picking features, in the src directory, find Main.java, right click it and run it.
In console you can give following commands:

```
//base commands:
vehicle left //add one vehicle on left road
vehicle right
step //advance scenario in time(could lead to light switching, depends on used strategy)
state //print the state of roads.

//Pedestrians feature activated:
pedestrian left // add one pedestrian on the left road
pedestrian right

//Top feature activated:
vehicle top //add vehicle on top road
//Pedestrian and Top feature activated:
pedestrian top

//Bottom feature activated:
vehicle bottom //add vehicle on bottom road
//Pedestrian and Bottom feature activated:
pedestrian bottom
```
Be careful, the command parser is not well implemented and any wrong input will break the running instance.

# How to read instance State

state example:
```
LVr0 RVr1 TVg2 BVg4
```
every chunk of the state line describes one road: LVr0 describes the state of the Left road "L". "V" indicates that the following information are about the vehicles road. "r" indicates the trafficlight color of this road, "r" for red, "o" for orange and "g" for green. the number indicates the count of vehicles on "L" road.

If Pedestrian feature were activated the state will look like the following:

```
LVr0Pg0 RVr1Pg2 TVg2Pr3 BVg4Pr0
```
"P" for pedestrians, "g" or "r" for the light of pedestrians' passage, and the number indicates how many pedestrians are there at a time.
