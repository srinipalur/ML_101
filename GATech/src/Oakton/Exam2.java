package Oakton;
/*  Srinivas Palur 11/18/2025
 */
import java.util.Random;
public class Exam2 {
    public static void main(String[] args) {
        Random random = new Random();
        Exam2 obj = new Exam2();
        int[] randNums = new int[20];
        int randomNum;
        int evenSum = 0, oddAltSum = 0;
        System.out.print("Array: ");
        for(int i = 0; i < randNums.length; i++) {
            randomNum = random.nextInt(99) + 1;
            randNums[i] = randomNum;
            System.out.print(randomNum + " ");
            if(i % 2 == 0)
                evenSum += randomNum;
            if(i % 2 == 1 && (i-1) % 4 == 0)
                oddAltSum += randomNum;
        }
        System.out.println();
        System.out.println("sum of the even index values: " + evenSum);
        System.out.println("sum of every other odd index value: " + oddAltSum);
        System.out.println("average: " + obj.average(randNums));
    }

    double average(int v[]) {
        double sumTotal = 0.0;
        for(int i = 0; i < v.length; i++)
            sumTotal += v[i];
        return sumTotal/v.length;
    }
}