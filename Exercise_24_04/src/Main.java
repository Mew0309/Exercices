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
class Exercise_50_Primes {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        final int NUMBER_OF_PRIMES = 50; // Number of prime numbers
        int count = 0;
        int num = 2; // Starting number to check for primes

        while (count < NUMBER_OF_PRIMES) {
            if (isPrime(num)) {
                stack.push(num);  // Use push method
                count++;
            }
            num++;
        }

        System.out.println("The first 50 prime numbers in descending order: ");
        while (!stack.isEmpty()) {  // Use isEmpty method
            System.out.print(stack.pop() + " ");  // Use pop method
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

