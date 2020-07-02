# lab-02-oop

## Question 5

#### Why do we separate the interfaces from the implementation? Additionally, why are the implementations "package-private"?

It feels a lot cleaner, but I suspect its more to do with the fact that once the system is complete you only wanna be using the interface not the implementation, which probably makes it easier for clients as well. This leads onto why it's package private basically we want to hide the methods. 

#### What issues did you encounter in this model's implementation?

Getting the testing to work for the whole model was really hard, because I found linking the classes hard, but I was really just overthinking it.

#### Did you find any implementation errors when you wrote test cases?

Yes, in the majority of my remove or drop functions I used an if with contains instead of equals so they would always return the last element in the last instead of the needed index.
Additionally my lists were not initialized properly so adding always gave me a null pointer exception.
