package LazyAndThreadSafe;

/*
 * Concept:
 * Since the "Eager" approach creates the object as soon as the class is loaded (which might waste memory
 * if it's never used), Lazy Initialization is the preferred evolution. It waits until the very
 * last second—the moment getInstance() is called—to create the object.
 * NOTES:
 * To make this safe for professional use, we also need to handle Thread Safety so two different threads
 * don't accidentally create two different objects at the same time.
 *
 */

/**
 * Singleton Class - Lazy Initialization (Thread-Safe)
 */
// This code uses the Double-Checked Locking principle.
public class Abc2 {
    
    // 1. Volatile keyword ensures that multiple threads handle the 'obj'
    // variable correctly when it is being initialized.
    private static volatile Abc2 obj;
    
    // 2. Private constructor prevents instantiation from other classes.
    private Abc2(){
        System.out.println("Abc2 Instance Created Lazily!");
    }
    
    /**
     * 3. Global Access Point with Double-Checked Locking
     * This is more efficient than making the whole method synchronized.
     */
    public static Abc2 getInstance() {
        
        // First check (no locking): If instance exists, return it immediately.
        if (obj == null) {
            
            // Synchronize on the class level to ensure only one thread enters.
            synchronized (Abc2.class) {
                
                // Second check: If another thread initialized it while we waited for the lock.
                if (obj == null) {
                    obj = new Abc2();
                }
            }
        }
        
        return obj;
    }
    
    public void doWork() {
        System.out.println("Singleton is performing a task...!");
    }
    
}
