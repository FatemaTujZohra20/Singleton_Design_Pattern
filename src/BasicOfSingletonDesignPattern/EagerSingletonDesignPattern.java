package BasicOfSingletonDesignPattern;

/**
 * Main Entry Point.
 * This class demonstrates how to consume the Singleton defined in ABC.java.
 * Singleton Design Pattern - Eager Initialization
 * * Purpose: Ensures that only one instance of the class exists in the Java Virtual Machine (JVM).
 * Use Cases: Database connection pools, logging, configuration settings, or caching.
 */
public class EagerSingletonDesignPattern {
    
    public static void main (String[] args) {
        
        /* * Note: ABC obj3 = new ABC();
         * The line above would cause a COMPILATION ERROR because
         * the constructor in ABC.java is private.
         */
        
        // Requesting the instance for the first time
        ABC obj1 = ABC.getInstance();
        
        // Requesting the instance for the second time
        ABC obj2 = ABC.getInstance();
        
        
        // --- Verification ---
        
        // 1. Identity Check
        // '==' compares the memory addresses. If true, they are literally the same object.
        System.out.println("Same object? " + (obj1 == obj2));
        
        // 2. HashCode Check
        // Hash codes are unique identifiers for objects. Same object = Same hash code.
        System.out.println("Object 1 HashCode: " + obj1.hashCode());
        System.out.println("Object 2 HashCode: " + obj2.hashCode());
        
        if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("SUCCESS: Both variables share the same instance.");
        }
        
        // Using the singleton
        obj1.showMessage();
    }
}
