# Toy Robot Simulator

A simple project to simulate robot movement.

  - Uses Java 8.
  - Gradle.

### How to Run

You only need Java 8 on your machine.

To run the application .

```sh
$ ./gradlew clean test run
```
This would run all tests, and then execute the main application. 
**com.faziz.assignment.sim.ToyRobotSimulator** is the entry point for the application.
The application loads the commands for the robot from **src/main/resources/robot-commands.txt** file.

### Abstractions
  - **Direction** - to describe the four directions the robot could have based on commands.
  - **Rotation** - LEFT or RIGHT - to describe robot's rotation off of it's current direction.
  - **Point** - to describe the position of the robot on the table top.
  - **TableTop** - keeps track of robot's position and validates robot's movements.

### Todos

 - Write MORE Tests.