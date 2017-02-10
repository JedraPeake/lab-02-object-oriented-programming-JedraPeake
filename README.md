# lab-02-oop
##Question 5
####Why do we separate the interfaces from the implementation? Additionally, why are the implementations "package-private"?


####What issues did you encounter in this model's implementation?


####Did you find any implementation errors when you wrote test cases?
Yes, in the majority of my remove or drop functions I used an if with contains instead of equals so they would always return the last element in the last instead of the needed index.
Additionally my lists were not initialized properly so adding always gave me a null pointer exception.