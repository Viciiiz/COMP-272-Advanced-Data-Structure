public class Collatz {

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
      //  while (true){
            collatz((2L <<50) - 1 );//(long) Math.pow(2,63)-1);
      //      i++;
      //  }
    }
}

// n = (2^102321) - 1
// n = (2^63) - 1
/**
 * Any solution to a computational problem, improvements can be made in the following ways.
 * 1. research into the problem and use existing work (that was previously done)
 * 2. algorithmic improvement (clever solution)
 * 3. data structures
 *
 * After this,
 * 4. code level improvement (lot of little things or tricks you can do)
 * 5. (ignoring changing to a faster processor, or more memory)
 * 6. parallelism - which use of multiple cores on your computer
 */
