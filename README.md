# Specification

The purpose of this assignment is to design and implement a carpark in Java through use of threading and concurrency. The program models a carpark with a capacity size of 1000 spaces, and each car that uses the carpark can meet 3 potential error cases, either on entrance, exit or double parking which results in entrace blocking, exit blocking, or a car taking up 1.5 spaces respectively. The design principles for the carpark's use is the fair allocation of spaces under the condition that the carpark is not full. The probabilities used for the error scenarios are as follows:

Entrance problem: 0.055%
Exit problem: 0.096%
Double parking: 0.14%
