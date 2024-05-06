import java.util.Scanner;
public class Program {
    public static void main(String[] args) {

    }

    public static Scanner s = new Scanner(System.in);
    public static void creatArrWithSize(){
        int[] arr;
        System.out.println("Enter a size for arr: ");
        int size = s.nextInt();
        arr = creatArr(size);
    }
    public static int[] creatArr(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter a number " + (i+1) +":");
            arr[i] = s.nextInt();
        }
        return arr;
    }
    //----------------------------------------------------------------
    public static void Ex1(){
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i <= 9 ; i++) {
            System.out.println("Enter a number " + (i+1) + " :");
            int num = s.nextInt();
            arr[i] = num;
            sum += num;
        }
        theNumbersHighThenAvg(sum,arr);
    }
    public static void theNumbersHighThenAvg(int sum, int[] arr){
        int avg = 0;
        avg = sum/10;
        System.out.println("The avg is --->  " + avg);
        System.out.println("The number higher then avg is: ");
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > avg ){
                System.out.print(arr[i] +" ");
            }
        }
    }
    //----------------------------------------------------------------
    public static void Ex2(){
        System.out.println("Enter a number phone: ");
        String number = s.next();
        String res = checkPhoneNumber(number);
        if (res == null){
            System.out.println("The number invalid");
        }else {
            System.out.println(res);
        }
    }
    public static boolean lengthPhone(String phone){
        return phone.length() > 9 && phone.length() < 13;
    }
    public static String checkPhoneNumber(String number){
        String res = null;
        String prefix = "05";
        if (lengthPhone(number)){
            if (number.startsWith("972")){
                res = "0" + number.substring(3,5) + "-" + number.substring(5);
            }else if (number.startsWith(prefix) && !number.contains("-")){
                res = number.substring(0,3) + "-" + number.substring(3);
            }else if (number.startsWith(prefix) && number.charAt(3) == '-'){
                    res = number;
            }
        }
        return res;
    }
    //----------------------------------------------------------------
    public static void Ex3(){
        int[] originalArray = {1, 4, 7, 1, 8, 9, 2, 1, 3, 8, 0};
        int[] uniqueArray = removeDuplicates(originalArray);

        System.out.print("Unique elements in the array: ");
        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }
    }
    public static int[] removeDuplicates(int[] arr) {
        int[] result = new int[arr.length]; // גודל המערך המוחזר לא יעלה על גודל המערך המקורי
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result[index++] = arr[i];
            }
        }

        int[] uniqueArray = new int[index];
        for (int i = 0; i < index; i++) {
            uniqueArray[i] = result[i];
        }

        return uniqueArray;
    }
    //----------------------------------------------------------------
    public static void Ex4() {
        int[] upAndDown = {1, 3, 6, 11, 10, 9, 4, 2, 0};
        int result = arrayGoesUpAndDown(upAndDown);
        System.out.println(result);
    }
    public static int arrayGoesUpAndDown(int[] arr){
        int highestIndex = 0;
        int highestNumberInArr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highestNumberInArr){
                highestNumberInArr = arr[i];
                highestIndex = i;
            }
        }
        int length = arr.length -1;
        if (highestIndex == length){
            highestIndex = -1;
        }
        return highestIndex;
    }
    //----------------------------------------------------------------
    public static void Ex5(){
        System.out.println("|WELCOME TO THE GAME X & O |");
        char[] chars = {'1','2','3','4','5','6','7','8','9',' '};
        boolean res = false;
        printBoard(chars);
        while(!res) {
            int target = getPositionFromUser(chars) - 1;
            System.out.println("Enter your symbol (x||o) --->");
            char ch = s.next().charAt(0);
            if (placeSymbolOnBoard(chars, target, ch)) {
                res = true;
            } else {
                System.out.println();
                System.out.println("Continued --->");
            }
            System.out.println();
        }
        System.out.println("|GAME OVER|");
    }//משחק איקס עיגול
    public static void printBoard(char[] chars){
               for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i] +" ");
                if (i == 2){
                    System.out.println();
                }
                if (i == 5){
                    System.out.println();
                }
        }
        System.out.println();
    }
    public static boolean isAvailable(char[] chars, int target){
        boolean res = true;
        if (chars[target] == 'o' ||chars[target ] == 'x'){
            res = false;
        }
        return res;
    }
    public static int getPositionFromUser(char[] chars){
        boolean res = false;
        int target = 0 ;
        System.out.println("Enter the position you want to insert your icon\n" +
                "( x || o ) The options are 1-9 --- >");
        while (!res){
             target = s.nextInt() ;
            if (isValidNumber(target)){
                if (thePositionIsAvailable(chars,target -1)){
                    res = true;
                }else {
                    System.out.println("The place is taken, try again.");
                }
            }else {
                System.out.println("You must enter a number in the number range between 1-9.");
            }
        }
        return target;
    }
    public static boolean isValidNumber(int num){
        return num >= 1 && num <= 9 ;
    }
    public static boolean thePositionIsAvailable(char[] chars, int num){
        return isAvailable(chars,num);
    }
    public static char checkWinner(char[] chars) {
        char winner = '-';
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (chars[i] != ' ' && chars[i] == chars[i + 1] && chars[i] == chars[i + 2]) {
                winner = chars[i];
                return winner;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (chars[i] != ' ' && chars[i] == chars[i + 3] && chars[i] == chars[i + 6]) {
                winner = chars[i];
                return winner;
            }
        }
        // Check diagonals
        if (chars[0] != ' ' && chars[0] == chars[4] && chars[0] == chars[8]) {
            winner = chars[0];
            return winner;
        }
        if (chars[2] != ' ' && chars[2] == chars[4] && chars[2] == chars[6]) {
            winner = chars[2];
            return winner;
        }
        return winner;
    }
    public static boolean theGameIsOver(char[] chars){
        boolean gameOver = false;
        int countForGameOver = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x' || chars[i] == 'o'){
                countForGameOver++;
            }
        }
        if (countForGameOver == 9){
            System.out.println("There are no winner :(");
            gameOver = true;
        }
        return gameOver;
    }
    public static boolean placeSymbolOnBoard(char[] chars, int target, char symbol){
       if (isAvailable(chars,target)){
           chars[target] = symbol;
       }
       printBoard(chars);
       char res = checkWinner(chars);
       boolean temp = false;
       if (res != '-'){
           System.out.println("The winner is ---> " + res);
           temp = true;
       } else if (theGameIsOver(chars)) {
           System.out.println("There are no winner :(");
           temp = true;
       }
        return temp;
    }
    //----------------------------------------------------------------
    public static void Ex6() {
        System.out.println("Enter a quadratic equation of the form |ax^2+bx+c=0| ---> ");
        String equation = s.next();

    }

}


   

