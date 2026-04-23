Part 1:

Shared Resource #1: nextId (the integer counter used to assign unique IDs)

Shared Resource #2: requests (the ArrayList that stores all requests)

Concurrency Problem: A race condition can occur if multiple threads call addRequest() at the same time. This can lead to duplicate IDs or inconsistent updates to the request list.

Why addRequest() is unsafe: addRequest() is unsafe because it is not synchronized. Two threads can both call getNextId() and read the same value of nextId before either increments it, resulting in duplicate request IDs. Additionally, ArrayList is not thread-safe, so concurrent add() operations can corrupt the list or cause inconsistent behavior.

Part 2:

Fix A: Not correct. This fixes the nextId issue by making sure only one thread can generate an ID at a time. However, it does NOT fix the problem with the requests list. Multiple threads can still call requests.add(request) at the same time. Since ArrayList is not thread-safe, this can still lead to corrupted data or inconsistent behavior.

Fix B:
Correct. This works because it synchronizes the entire addRequest() method, which includes BOTH getting the nextId and adding to the requests list. So now only one thread can run this whole process at a time. This prevents duplicate IDs AND prevents concurrent modification of the ArrayList.

Fix C: Not correct. This only synchronizes getRequests(), which is not where the main problem is. It does nothing to protect nextId or the requests.add(request) inside addRequest().Therefore the race condition still exists.


Part 3:
 No, getNextId() should not be public. Based on Arthur’s Riel’s heuristics, classes should be encapsulated and hide their internal implementation details, only exposing what is necessary. getNextId() is an internal helper method that manages how IDs are generated, and it should only be used inside the class. If it were public, external code could call it directly, which could break the logic of the system (for example, generating IDs without actually creating requests). So keeping it private helps maintain control over the object’s state and ensures IDs are only created as part of addRequest().

Part 4:
Description: The alternative approach is to use a Lock, such as ReentrantLock, instead of the synchronized keyword. The lock is used to protect the critical section inside addRequest(). Before generating the ID and adding to the list, the thread acquires the lock. When it is finished, it releases the lock so another thread can proceed. This ensures that both ID generation and modification of the requests list occur atomically, preventing race conditions and ensuring thread safety.

Code Snippet:
private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}