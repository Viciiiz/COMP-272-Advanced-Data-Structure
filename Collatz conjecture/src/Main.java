public class Main {

    public static void collatz (long i){
        long number = i;
        long step = 0;
        while (number!=1){
            if (number % 2 == 1){
                number = number * 3 + 1;
            } else {
                number /= 2;
            }
            step++;
        }
        System.out.println("True for i = " + i + " because it tends to " + number + " with the following number of steps: " + step);
    }

    public static void main(String[] args) {
        long i = 1;
        while (true){
            collatz(i);
            i++;
        }
    }
}

// n = (2^102321) - 1
// n = (2^63) - 1
