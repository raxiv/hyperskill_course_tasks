import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();

        switch (choice){
            case "triangle":
                double one = scanner.nextDouble();
                double two = scanner.nextDouble();
                double three = scanner.nextDouble();
                double p = (one+two+three)/2;
                double result = Math.sqrt(p*(p-one)*(p-two)*(p-three));
                System.out.println(result);
                        break;
            case "rectangle":
                double oneSide = scanner.nextDouble();
                double twoSide = scanner.nextDouble();
                System.out.println(oneSide*twoSide);
                break;
            case "circle":
                double r = scanner.nextDouble();
                double solution = 3.14*r*r;
                System.out.println(solution);
                break;
        }







    }
}