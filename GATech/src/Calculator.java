import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String optionsString = "List of operations: add subtract multiply divide alphabetize";
        boolean terminate = false;
        while(!terminate) {
            System.out.println(optionsString);
            System.out.println("Enter an operation:");
            String optionEntered = input.next().toLowerCase();
            switch (optionEntered) {
                case "add":
                    System.out.println("Enter two integers:");
                    try {
                        int num1 = input.nextInt();
                        int num2 = input.nextInt();
                        int answer = num1 + num2;
                        System.out.println("Answer: " + answer);
                    } catch (Exception e) {
                        terminate = true;
                    }
                    break;
                case "subtract":
                    System.out.println("Enter two integers:");
                    try {
                        int num1 = input.nextInt();
                        int num2 = input.nextInt();
                        int answer = num1 - num2;
                        System.out.println("Answer: " + answer);
                    } catch (Exception e) {
                        terminate = true;
                    }                    
                    break;
                case "multiply":
                    System.out.println("Enter two doubles:");
                    try {
                        double doub1 = input.nextDouble();
                        double doub2 = input.nextDouble();
                        double answer2 = doub1 * doub2;
                        System.out.printf("Answer: %.2f%n", answer2);
                    } catch (Exception e) {
                        terminate = true;
                    }
                    break;
                case "divide":
                    System.out.println("Enter two doubles:");
                    try {
                        double doub1 = input.nextDouble();
                        double doub2 = input.nextDouble();
                        if(doub2 == 0) {
                            terminate = true;
                        }
                        else {
                            double answer2 = doub1/doub2;
                            System.out.printf("Answer: %.2f%n", answer2);
                    }
                    } catch (Exception e) {
                        terminate = true;
                    }                    
                    break;
                case "alphabetize":
                    System.out.println("Enter two words:");
                    String word1 = input.next();
                    String word2 = input.next();
                    String word1_conv = word1.toLowerCase();
                    String word2_conv = word2.toLowerCase();
                    int comparison = word1_conv.compareTo(word2_conv);
                    if(comparison == 0)
                        System.out.println("Answer: Chicken or Egg.");
                    else if (comparison < 0)
                        System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                    else
                        System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                    break;
                default:
                    terminate = true;
                    break;
            }
            if(terminate)
                System.out.println("Invalid input entered. Terminating...");

            break;
        }        
    }
}
