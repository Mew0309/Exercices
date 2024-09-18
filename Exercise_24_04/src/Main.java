import java.util.LinkedList;


class GenericStack<E> {
    private final LinkedList<E> list = new LinkedList<>();

    // Push an element onto the stack
    public void push(E element) {
        list.addFirst(element);
    }

    // Pop an element from the stack
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    // Peek at the top element of the stack
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
