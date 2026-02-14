package BasicOfSingletonDesignPattern;

// This file defines the Singleton resource.
/**
 * The Singleton Class.
 * This class is designed to ensure only one instance ever exists.
 */
public class ABC {
    
    /**
     * 1. STATIC INSTANCE
     * This 'obj' is created when the class is loaded by the JVM.
     * Being 'static', it belongs to the class itself, not any specific instance.
     */
    static ABC obj = new ABC();
    
    /**
     * 2. PRIVATE CONSTRUCTOR
     * By making this constructor private, we "lock" the class.
     * No other class (including BasicOfSingletonDesignPattern) can
     * call 'new ABC()'. This is the core of the Singleton pattern.
     */
    private ABC(){
        // Initialize heavy resources here (e.g., DB connections)
        System.out.println("ABC Instance Created!");
    }
    
    /**
     * 3. GLOBAL ACCESS POINT
     * This is the only way for the outside world to interact with ABC.
     * It returns the pre-created 'obj' every single time it is called.
     * * @return The single, unique instance of ABC.
     */
    public static ABC getInstance() {
        return obj;
    }
    
    // Example of a functional method inside the singleton
    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }
}
