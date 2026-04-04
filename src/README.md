# ➡️ Basic of Singleton Design Pattern

## The Singleton Design Pattern

    The Singleton pattern is a creational design pattern that ensures a class has only one instance 
    throughout the lifecycle of an application and provides a global access point to that instance. 
    It is typically implemented by making the class constructor private to prevent external instantiation,
    maintaining a private static variable to hold the single instance, and exposing a public static method
    (commonly getInstance()) that returns that instance. On the first call, the method creates the object 
    if it does not already exist; on subsequent calls, it returns the same object. This pattern is useful 
    for shared resources such as configuration managers, logging services, caches, or connection managers,
    where having multiple instances could cause inconsistency or resource conflicts. In modern Java, 
    thread safety must be considered—using techniques like synchronized access, double-checked locking 
    with volatile, or an enum-based Singleton, which is the most robust approach.


## The public static method
In the context of the Singleton pattern, the public static method (usually named getInstance()) 
is the global access point to the single object.

Explanation:

In a Singleton, the constructor is made private, which means no other class can create an object using new.
Because of that restriction, we need a controlled way to access the single instance. 
That is where the public static method comes in.

- public → So it can be accessed from anywhere in the application.

- static → So it belongs to the class itself, not to an object. This is important because we need to 
call the method without already having an object.

- method (getInstance) → Returns the single stored instance of the class.

Example:

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


Here’s the key logic:

You cannot do: **new Singleton()** (constructor is private).

So you call: **Singleton.getInstance()**

### _**Since it’s static, you call it using the class name.**_

It either creates the object (first time) or returns the already created one.

In short:

    The public static method in Singleton is the controlled, global entry point that provides 
    access to the one and only instance of the class.

### 💎 Comparison of Approaches (Eager Initialization vs Lazy Initialization)

| Feature | Eager Initialization | Lazy (Double-Checked) |
|---|---|---|
| Memory | Allocated at startup (could be wasteful) | Allocated only when needed |
| Performance | Faster getInstance() calls | Slight overhead on the first call |
| Complexity | Very simple | More complex code (requires volatile and synchronized) |
| Thread Safety | Handled by JVM class loader | Handled manually via locking |


#  🔴 The Bill Pugh Singleton Design Pattern

## The Static Inner Helper Class pattern

    The Bill Pugh Singleton (also known as the Static Inner Helper Class pattern) is widely considered
    the most elegant way to implement a Singleton in Java.
    It achieves Lazy Initialization and Thread Safety without using synchronized blocks or volatile keywords, 
    making it highly performant.

Or, 

    The Bill Pugh Singleton is a variation of lazy initialization that ensures thread safety
    without using synchronized blocks. It leverages the Java class loader mechanism to guarantee that 
    the instance is created only when the inner SingletonHelper class is referenced.

### 💎 Why is this (Bill Pugh Singleton) better than Double-Checked Locking?

| Feature | Double-Checked Locking          | Bill Pugh Method                |
|---|---------------------------------|---------------------------------|
| Lazy Loading | Yes                             | Yes                             |
| Performance | Good, but has minor locking overhead | Excellent (No locking required) |
| Complexity | High (Requires volatile, synchronized) | Low (Simple inner class)        |
| Java Version | Requires Java 5+ for volatile fix     | Works on all versions    |


### Summary of the Mechanics
- Initialization on Demand: The SingletonHelper class is not referenced anywhere else. 
Therefore, the JVM will not load it (and thus not create INSTANCE) until someone explicitly calls Cde.getInstance().

- Zero Synchronization: Because the JVM guarantees that static initializers are thread-safe during class loading, 
we don't need to write any synchronized code ourselves.




