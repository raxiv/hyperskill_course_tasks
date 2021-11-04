package numbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

enum Properties {
    EVEN,
    ODD,
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SQUARE,
    SUNNY,
    JUMPING;
}


public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner scanner = new Scanner(System.in);


        boolean isExit = true;
        instruction();
        System.out.println("Enter a request");
        while (isExit) {

            String request = scanner.nextLine();

            if (request.contains(" ")) {
                String[] array = request.split(" ");

                {
                    long first = Long.valueOf(array[0]);
                    long second = Long.valueOf(array[1]);

                    String property = "";
                    String property2 = "";
                    long numberOfLoops = 0;
                    int correctProp = 0;
                    if (first < 0) {
                        System.out.println("The first parameter should be a natural number or zero.");

                    }
                    if (second < 0) {
                        System.out.println("The second parameter should be a natural number.");
                        System.out.println("Enter a request");
                        continue;
                    }

                    if (array.length > 4) { //wiecej properties
                        long found = 0;
                        int correctProperties = 0;
                        String[] propArray = Arrays.copyOfRange(array, 2, array.length);
                        int numberOfProperties = propArray.length;

                        for (int i = 0; i < numberOfProperties; i++) {//sprawdzenie property
                            if (isProperty(propArray[i])) {
                                correctProperties++;
                                continue;
                            } else {
                                System.out.println("The property " + array[i] + " is wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                                System.out.println("Enter a request");
                            }

                        }
                      if(isLegitProperty(propArray)){
                          if (correctProperties == numberOfProperties) {//jak mamy wszystkie prawidlowe property
                              for (long i = first; found < second; i++) {

                                  correctProp = 0;

                                  for (int j = 0; j < propArray.length; j++) {

                                      if (isPropertyChecker(propArray[j], i)) {
                                          correctProp++;
                                          if (correctProp == propArray.length) {
                                              printProperties(i);
                                              found++;
                                          }
                                      }
                                  }
                              }
                              System.out.println("Enter a request");


                          }
                      }

                    }

                    if (array.length == 4) { //4 arg
                        property = array[2];
                        property2 = array[3];
                        String[] propArrayss = new String[2];
                        propArrayss[0] =property;
                        propArrayss[1] = property2;
                        if(isLegitProperty(propArrayss)){
                            if (isProperty(property.toLowerCase()) && !isProperty(property2.toLowerCase())) {
                            System.out.println("The property " + property2 + " is wrong.\n" +
                                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                            System.out.println("Enter a request");

                        }
                            if (!isProperty(property.toLowerCase()) && isProperty(property2.toLowerCase())) {
                                System.out.println("The property " + property + " is wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                                System.out.println("Enter a request");
                            }
                            if (isProperty(property.toLowerCase()) && isProperty(property2.toLowerCase())) {
                                long found = 0;
                                for (long i = first; found < second; i++) {
                                    if (isPropertyChecker(property, i) && isPropertyChecker(property2, i)) {
                                        printProperties(i);
                                        found++;
                                    }
                                }

                            } else {
                                System.out.println("The properties " + property + " " + property2 + " are wrong.\n" +
                                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                            }
                            System.out.println("Enter a request");
                            continue;
                        }
                    }





                    if (array.length == 3) { //3 argumenty
                        property = array[2];
                        propertyListForSpy(first, second, property);
                        continue;

                    }

                    if (array.length == 2) { //2 argumenty
                        for (long i = first; numberOfLoops <= second; i++) {
                            printProperties(i);
                            numberOfLoops++;
                        }
                    }


                }

            } else if (request.isEmpty()) {//pusta
                instruction();
                System.out.println("Enter a request");
                continue;
            } else {//dla 1 arg
                long number = Long.valueOf(request);
                if (number == 0) {
                    System.out.println("Goodbye!");
                    isExit = false;
                } else oneNumber(number);
            }
        }


    }

    public static boolean isLegitProperty(String[] arrayOfProperties) {
        boolean isEven = false;
        boolean isOdd = false;
        boolean isSunny = false;
        boolean isSquare = false;
        boolean isDuck = false;
        boolean isSpy = false;
        boolean isHappy = false;
        boolean isSad = false;
        boolean minusOdd = false;
        boolean minusEven = false;
        boolean minusDuck = false;

        String[] checkingArray = arrayOfProperties;
        for (int i = 0; i < checkingArray.length; i++) {
            if(checkingArray[i].equals("even")){
                isEven=true;
            }
            if(checkingArray[i].equals("odd")){
                isOdd=true;
            }
            if(checkingArray[i].equals("spy")){
                isSpy=true;
            }
            if(checkingArray[i].equals("square")){
                isSquare=true;
            }
            if(checkingArray[i].equals("sunny")){
                isSunny=true;
            }
            if(checkingArray[i].equals("duck")){
                isDuck=true;
            }
            if(checkingArray[i].equals("happy")){
                isHappy=true;
            }
            if(checkingArray[i].equals("sad")){
                isSad=true;
            }
            if(checkingArray[i].equals("-odd")){
                minusOdd=true;
            }
            if(checkingArray[i].equals("-even")){
                minusEven=true;
            }if(checkingArray[i].equals("-duck")){
                minusDuck=true;
            }

        }

        if(isEven&&isOdd){
            System.out.println("The request contains mutually exclusive properties: EVEN ODD" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if(isSpy&&isDuck){
            System.out.println("The request contains mutually exclusive properties: SPY DUCK" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if (isSquare && isSunny) {

            System.out.println("The request contains mutually exclusive properties: SQUARE SUNNY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if(isSad&&isHappy){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }if(isOdd&&minusOdd){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if(isSad&&isHappy){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        } if(minusEven&&minusOdd){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if(minusEven&&isEven){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
        if(isDuck&&minusDuck){
            System.out.println("The request contains mutually exclusive properties: SAD HAPPY" +
                    " There are no numbers with these properties.");
            System.out.println("Enter a request");
            return false;
        }
return true;
    }


    public static boolean isProperty(String property) {
        String[] properties = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING","SAD","HAPPY",
        "-DUCK","-SPY","-EVEN", "-ODD", "-BUZZ", "-PALINDROMIC", "-GAPFUL", "-SQUARE", "-SUNNY", "-JUMPING","-SAD","-HAPPY"};
        for (String propert : properties) {

            if (property.equals(propert.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    public static boolean isPropertyChecker(String property, long number) {
        if (property.equals("even")) {
            return isEven(number);
        } else if (property.equals("spy")) {
            return isSpy(number);
        } else if (property.equals("palindromic")) {
            return isPalindromic(number);
        } else if (property.equals("odd")) {
            return isOdd(number);
        } else if (property.equals("buzz")) {
            return isBuzz(number);
        } else if (property.equals("duck")) {
            return isDuck(number);
        } else if (property.equals("gapful")) {
            return isGapful(number);
        } else if (property.equals("square")) {
            return isSquare(number);
        } else if (property.equals("sunny")) {
            return isSunny(number);
        } else if (property.equals("jumping")) {
            return isJumping(number);
        }else if (property.equals("sad")) {
            return isSad(number);
        }else if (property.equals("happy")) {
            return isHappy(number);
        }else if (property.equals("-duck")) {
            return !isDuck(number);
        }else if (property.equals("-spy")) {
            return !isSpy(number);
        }else if (property.equals("-odd")) {
            return isOdd(number);
        }else if (property.equals("-even")) {
            return isEven(number);
        }
        return false;
    }

    public static void oneNumber(long number) {
        if (number == 0) {
            System.out.println("Goodbye!");

        } else if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println("enter a request");

        } else {
            System.out.println("Properties of " + number);
            System.out.println("even: " + isEven(number));
            System.out.println("odd: " + isOdd(number));
            System.out.println("buzz: " + isBuzz(number));
            System.out.println("duck: " + isDuck(number));
            System.out.println("palindromic: " + isPalindromic(number));
            System.out.println("gapful: " + isGapful(number));
            System.out.println("spy: " + isSpy(number));
            System.out.println("square: " + isSquare(number));
            System.out.println("sunny: " + isSunny(number));
            System.out.println("jumping: " + isJumping(number));
            System.out.println("happy: " + isHappy(number));
            System.out.println("sad: " + isSad(number));
            System.out.println("Enter a request");

        }
    }


    public static boolean isSquare(long number) {
        if (Math.sqrt(number) % 1 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isSunny(long number) {
        if (Math.sqrt(number + 1) % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void propertyListForSpy(long first, long second, String property) {
        property = property.toLowerCase();

        long numberOfCorrect = 0;
if(property.charAt(0)=='-'){
    property = property.substring(1);
    while (numberOfCorrect != second) {

        switch (property) {
            case "even":
                if (!isEven(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "odd":
                if (!isOdd(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "buzz":
                if (!isBuzz(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "duck":
                if (!isDuck(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "palindromic":
                if (!isPalindromic(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "gapful":
                if (!isGapful(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "spy":
                if (!isSpy(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "square":
                if (!isSquare(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "sunny":
                if (!isSunny(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "jumping":
                if (!isJumping(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }case "happy":
                if (!isHappy(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "sad":
                if (!isSad(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }

            default:
                System.out.println("The property " + property + " is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SADd]");
                System.out.println("Enter a request");
                numberOfCorrect = second;
                break;

        }

    }
}else{
    while (numberOfCorrect != second) {

        switch (property) {
            case "even":
                if (isEven(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "odd":
                if (isOdd(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "buzz":
                if (isBuzz(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "duck":
                if (isDuck(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "palindromic":
                if (isPalindromic(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "gapful":
                if (isGapful(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "spy":
                if (isSpy(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "square":
                if (isSquare(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "sunny":
                if (isSunny(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "jumping":
                if (isJumping(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }case "happy":
                if (isHappy(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }
            case "sad":
                if (isSad(first)) {
                    printProperties(first);
                    numberOfCorrect++;
                    first++;
                    break;
                } else {
                    first++;
                    break;
                }

            default:
                System.out.println("The property " + property + " is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SADd]");
                System.out.println("Enter a request");
                numberOfCorrect = second;
                break;

        }

    }
}


        System.out.println("enter a request");


    }


    public static void printProperties(long number) {
        System.out.println(number + " is " + (isBuzz(number) ? "buzz," : "") + (isDuck(number) ? "duck," : "")
                + (isEven(number) ? "even," : "") + (isPalindromic(number) ? "palindromic," : "")
                + (isOdd(number) ? "odd," : "") + (isGapful(number) ? "gapful," : "") + (isSpy(number) ? "spy," : "") +
                (isSquare(number) ? "square," : "") + (isSunny(number) ? "sunny," : "") + (isJumping(number) ? "jumping," : "")+
                (isSad(number) ? "sad," : "")+ (isHappy(number) ? "happy," : ""));
    }




    public static boolean isSad(long number){
        if(!isHappy(number)){
            return true;
        }
        return false;
    }

    public static boolean isHappy(long number){
        long result = number;
        while(result != 1 && result != 4){
           result = calculateSquares(result);
        }

        if(result == 1){
            return true;
        }
        return false;
    }

    public static long calculateSquares(long number){
        long sum = 0;
        long result = number;
        long remainder = 0;

        while(number!=0){
            remainder = number%10;
            sum = sum+(remainder*remainder);
            number =number/10;
        }
            return sum;
    }




    public static boolean isJumping(long number) {
        if (number > 0 && number < 11) {
            return true;
        }
        long lastdigit1 = 0;
        long lastdigit2 = 0;
        boolean isFirstTurn = true;

        while (number != 0) {
            lastdigit1 = number % 10;
            if (isFirstTurn) {
                number = number / 10;
                if (number != 0) {
                    lastdigit2 = number % 10;
                    number = number / 10;
                    if (Math.abs(lastdigit1 - lastdigit2) != 1) {
                        return false;
                    }
                }
                isFirstTurn = false;
            } else {
                if (Math.abs(lastdigit1 - lastdigit2) != 1) {
                    return false;
                } else {
                    lastdigit2 = lastdigit1;
                    number = number / 10;
                }
            }
        }
        return true;


    }


    public static boolean isSpy(long number) {
        long sum = 0;
        long product = 1;
        long remainder = 0;

        while (number > 0) {
            remainder = number % 10;
            sum += remainder;
            product *= remainder;
            number /= 10;
        }
        if (sum == product) {
            return true;
        } else {
            return false;
        }
    }


    public static void instruction() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

    }

    public static boolean isGapful(long number) {
        String n_string = Long.toString(number);
        if (n_string.length() < 3) {
            return false;
        } else {
            String firstDigitString = n_string.substring(0, 1);
            String lastDigitString = n_string.substring(n_string.length() - 1);
            String concat = firstDigitString + lastDigitString;
            long con = Long.parseLong(concat);
            return number % con == 0;
        }
    }

    public static boolean isPalindromic(long number) {
        if (number > 0 && number < 10) {
            return true;
        }

        long initialNumber = number;
        long reversed = 0;

        while (initialNumber != 0) {
            long remainder = initialNumber % 10;
            reversed = reversed * 10 + remainder;
            initialNumber /= 10;
        }
        if (number == reversed) {
            return true;
        }
        return false;
    }


    public static boolean isEven(long number) {
        return number % 2 == 0 ? true : false;
    }

    public static boolean isOdd(long number) {
        return number % 2 != 0 ? true : false;
    }


    public static boolean isBuzz(long number) {
        if (number == 7) {
            return true;
        }
        if (number % 7 == 0) {
            return true;
        }
        if (number % 10 == 7) {
            return true;
        }
        return false;
    }


    public static boolean isDuck(long number) {
        if (number < 10) {
            return false;
        }

        String number1 = String.valueOf(number);
        for (int i = 1; i < number1.length(); i++) {
            if (number1.charAt(i) == '0') {
                return true;
            }

        }
        return false;
    }
}
