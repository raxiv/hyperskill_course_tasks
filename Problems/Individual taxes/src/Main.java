import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        double[] yearlyIncome = new double[n];

        for (int i = 0; i <yearlyIncome.length ; i++) { //pobranie przychodow

            yearlyIncome[i] = scanner.nextDouble();
        }

        scanner.nextLine();
        double[] taxes = new double[n];

        for (int i = 0; i <taxes.length ; i++) { //pobranie taxow

            taxes[i] = scanner.nextDouble();
        }


        int mostTaxes = 0;
        double tax = 0;
        double biggestTax = 0;
        for (int i = 0; i <n ; i++) {
            if((taxes[i]>=0 && taxes[i]<=100)&&(yearlyIncome[i]>=0)){
                tax =yearlyIncome[i]*taxes[i]/100;
                if(tax>biggestTax){
                    biggestTax=tax;
                    mostTaxes=(int)(i+1);
                }
            }

        }

        System.out.println(mostTaxes);



        }


}