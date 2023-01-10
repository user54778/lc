package dynamicprogramming;

public class BottomUpFibonacci {
    /**
     * Calculate the Fibonacci Sequence in a Bottom Up approach, where we solve
     * each subproblem in order.
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {   // this part is required for lc, or it arrays index out of bounds exception
            return n;
        }
        int[] cache = new int[n + 1];
        // need to solve sub-problems in SIZE order
        // must need the previous solutions to be already solved

        // base cases are the first TWO numbers of the sequence
        cache[0] = 0;   // f(n - 2)
        cache[1] = 1;   // f(n - 1)

        // bottom-up typically implemented with iteration and starts with base cases, as the two we solved above
        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        BottomUpFibonacci fibonacci = new BottomUpFibonacci();
        System.out.println(fibonacci.fib(10));
    }
}
