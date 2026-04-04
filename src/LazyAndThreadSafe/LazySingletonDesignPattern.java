package LazyAndThreadSafe;

/**
 * Main Entry Point.
 */
public class LazySingletonDesignPattern {
    public static void main (String[] args) {
        System.out.println("LazySingleton Design Pattern");
        System.out.println("Program Started...");
        
        // The 'Abc2' object does NOT exist yet.
        // It will be created ONLY when the next line executes.
        Abc2 obj1 = Abc2.getInstance();
        
        // This call will simply return the existing object.
        Abc2 obj2 = Abc2.getInstance();
        
        // ------- Verification logic -------
        if (obj1 == obj2) {
            System.out.println("Success: Both references point to the same Lazy instance.");
        }
        
        System.out.println("Instance HashCode: " + obj1.hashCode());
        
        obj1.doWork();
    }

}
