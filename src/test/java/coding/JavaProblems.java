package coding;
import org.testng.annotations.Test;

import java.lang.*;
import java.util.*;

public class JavaProblems {


    //Print first 5 prime numbers
    @Test
    public void primeNumbers1(){
        int i = 2;
        int num;
        int primeCount = 1;
        while(primeCount <= 10) {
            num = 0;
            int j;
            for (j = 2; j <=i/2 ; j++) {
                if (i%j==0){
                    num++;
                    break;
                }
            }
            if (num==0){
                System.out.println(i + " is Prime");
                primeCount++;
            }
            i++;
        }
    }

    //Print all Prime numbers before certain number
    // start dividing by 2 till i/2
    @Test
    public void primeNumbers2() {
        int count;
        int i;
        for(i = 2; i<15 ; i++) {
            count = 0;
            int j;
            for(j = 2; j<=i/2; j++){
                if(i%j==0) {
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println(i + " is prime");
            }
        }
    }


    // start dividing by number itself and go till 1
    @Test
    public void primeNumbers3() {

        int i =0;
        int num =0;
        String  primeNumbers = "";
        for (i = 1; i <= 100; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to 100 are :");
        System.out.println(primeNumbers);
    }

    //count number of words in a String
    @Test
    public void countWords(){

        HashMap<String, Integer> map = new HashMap<>();
        String str = "my rishi name is rishi gupta my";
        String arr[] = str.split(" ");
        Integer count = 1;
        for (String word : arr) {
            if(map.containsKey(word))
                map.put(word, count+1);
            else
                map.put(word, count);
            }
        System.out.println(map);
        }

    //print unique element in array
    @Test
    public void uniqueElementsInArray() {
        String arr[] = {"abc" , "def", "abc", "def" , "klm"};
        HashMap<String, Integer> map = new HashMap<>();
        Integer count = 1;
        for (String word: arr) {
            if(map.containsKey(word))
                map.put(word, count+1);
            else
                map.put(word, count);
        }
        System.out.println(map.keySet());
    }

    //palindrome
    @Test
    public void palindrome(){
        String A = "madam";
        char[] arr = A.toCharArray();
        int len = arr.length;
        int flag = 0;
        for(int i = 0; i<len/2 ; i++) {
           if(arr[i] != arr[(len-1)-i]){
               System.out.println("No");
               flag++;
               break;
           }
        }
        if(flag == 0) {
            System.out.println("Yes");
        }

    }

    //Compare 2 Strings and check if Anagrams or not
    @Test
    public void anagrams(){
        String a = "cat";
        String b = "ctb";
        //test for invalid input
        if(a==null || b==null || a.equals("") || b.equals(""))
            throw new IllegalArgumentException();
        // initial quick test for non anagrams
        if(a.length() != b.length())
            System.out.println("No");

        a = a.toLowerCase();
        b = b.toLowerCase();

        //Populate a map with letters and frequencies of String b
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = 0; k<b.length(); k++) {
            char letter = b.charAt(k);
            if(!map.containsKey(letter))
                map.put(letter, 1);
            else {
                Integer frequency = map.get(letter);
                map.put(letter, ++frequency); }
        }

        //test each letter in String a against data in the map
        //return if letter is absent in the map or its frequency is 0
        //otherwise decrease the frequency by 1

        for(int k=0; k<a.length();k++) {
            char letter = a.charAt(k);
            if(! map.containsKey(letter))
                System.out.println("No");

            Integer frequency = map.get(letter);

            if(frequency == 0)
                System.out.println("No");
            else
                map.put(letter, --frequency);
        }
        System.out.println("Yes");

        }

    //sum of divisors of a given number
    @Test
    void sumOfDivisors(){
        int n = 5;
        int sum = 0;
        for(int i = 1; i<=n; i++)
            if(n%i==0) {
                sum = sum + i;
            }
        System.out.println(sum);
    }

    @Test
    void callFactorial() {
        int n = 4;
        if (n < 0) {
            System.out.println("Error");
        }
        System.out.println(factorial(n));
    }

    //Factorial of a number using Recursion
    int factorial(int n) {
       if (n == 0 || n == 1) {
           return 1;
       }
        return n * factorial(n - 1);
    }



    //print nth value of Fibonnaci series with iteration
    @Test
    public void printFibonacci() {
        long a = 0;
        long b = 1;
        long n = 50;
        long sum = 0;

        for (int i=2; i<=n; i++) {
            sum = a + b;
            a = b;
            b = sum; }

        System.out.println(b);
    }

    //print nth value of Fibonnaci series with recursion but high time complexity
    @Test
    public void callFibonacci() {
        System.out.println(fibonacci(9));
    }

    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //print all Fibonnaci until n with recursion
    private long[] fibonacciCache;
    @Test
    public void callFibonacciNew() {
        int n = 50;
        fibonacciCache = new long[n+1];
        for(int i = 0; i<=n; i++) {
            System.out.print(fibonacciNew(i) + " ");
        }
    }

    //print nth Fibonnaci with recursion storing values in Array for reuse and low time complexity
    public long fibonacciNew(int n) {
        if (n <= 1) {
            return n;
        }
        if(fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFibonacciNumber = (fibonacciNew(n-1) + fibonacciNew(n-2));
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }

    //print from 5 to 1 with recursion (Descending order)
    @Test
    void callPrintNumber(){
        printNumber(5);

    }

    void printNumber(int n){
        if(n == 0) {
            return;
        }

        System.out.println(n);
        printNumber(n-1);
    }


    //print from 1 to 5 with iteration
    @Test
    void printNumWithIteration(){
        int n = 5;
        for (int i = 1; i<=n; i++) {
            System.out.println(i);
        }
    }

    //print from 1 to 5 with recursion (Ascending order)
    @Test
    void callPrintNumberNew() {
        int n = 1;
        printNumberNew(n);

    }

    void printNumberNew(int n) {
        if(n == 6){
            return;
        }

        System.out.println(n);
        printNumberNew(n+1);
    }

    // print sum of first n natural numbers while traversing in descending order
    @Test
    void callSumOfNaturalNumbers() {
        System.out.println(sumOfNaturalNumbers(4));
    }

    int sumOfNaturalNumbers(int n){
        if (n == 1) {
            return n;
        }
        int partialAns =  sumOfNaturalNumbers(n-1);
        return n + partialAns;
    }

    // print sum of first n natural numbers while traversing in ascending order
    @Test
    void callSumOfNaturalNumbersNew() {
        System.out.println(sumOfNaturalNumbersNew(1));
    }

    int sumOfNaturalNumbersNew(int n){
        if (n == 4) {
            return n;
        }
        return n +  sumOfNaturalNumbersNew(n+1);
    }

    //Each policeman can catch Thief at a distance K=1
    @Test
    void catchThieves(){
        char arr[] = {'P', 'P', 'T', 'T', 'T', 'P'};
        int k = 1;
        int thievesCaught = 0;
        int i = 0;
        while (i<arr.length-1) {
            if ((arr[i] == 'P' && arr[i+k] == 'T') || (arr[i] == 'T' && arr[i+k] == 'P')) {
                thievesCaught++;
                 i = i+2;
            }
            else  {
                i++;
            }
        }
        System.out.println(thievesCaught);
    }


    //Print x^n (Stack Height = n)
    @Test
    void callStackHeight(){
        System.out.println(stacKHeight(2, 3));
    }

    public int stacKHeight(int x, int n) {
        if(x==0){
            return 0;
        } else if (n==1)
            return x;
        Stack stack = new Stack();
        System.out.println(stack.size());
        return x * stacKHeight(x, n-1);
    }

    //Print x^n (Stack Height = logn)
    @Test
    void callStackHeightWithLogN(){
        System.out.println(stacKHeightWithLogN(2, 3));

    }

    public int stacKHeightWithLogN(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        //if n is even
        if (n % 2 == 0) {
            return stacKHeightWithLogN(x, n / 2) * stacKHeightWithLogN(x, n / 2);
        }
        // when n is odd
        else {
            return stacKHeightWithLogN(x, n / 2) * stacKHeightWithLogN(x, n / 2) * x;
        }
    }

    //count how many 3's are present using character array
    @Test
    void countDigits() {
        Integer number = 133;
        char n = '3';
        int count = 0;
        char [] array = number.toString().toCharArray();
        for(char c: array) {
            if (c == n) {
                count++; }
        }
        System.out.println(count);
    }

    //count how many 3's are present using remainder when divide by 10
    @Test
    void countDigitsNew() {
        Integer number = 13313;
        int n = 3;
        int count = 0;
        while (number > 0) {
            if (number%10 == n) {
                count++; }
            number = number/10;
        }
        System.out.println(count);
    }

    //Reverse digits of given number
    @Test
    void reverseDigits() {
        Integer number = 5643;
        int ans = 0;
        while (number > 0) {
            int rem = number%10;
            ans = (ans*10)+rem;
            number = number/10;
        }
        System.out.print(ans);
    }

    //Reverse String
    @Test
    void reverseString() {
        String str = "Rishi";
        String reverseString = "";
        for(int i = str.length()-1; i>=0 ; i-- ) {
            reverseString += str.charAt(i);
        }
        System.out.println(reverseString);
    }

    //Solid Rectangle using nested loops Pattern
    @Test
    void printSolidRectangle(){
        for(int i=1; i<=2 ; i++){
            for (int j=1; j<=5; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //Hollow Rectangle using nested loops Pattern
    @Test
    void printHollowRectangle(){
        int n = 4;
        int m = 5;
        for(int i=1; i<=n; i++){
            for (int j=1; j<=m; j++) {
                if(i == 1 || i == n || j == 1 || j == m)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Half Pyramid or right angle triangle using nested loops Pattern
    @Test
    void printHalfPyramid(){
        int n = 5;
        int m = 5;
        for(int i=1; i<=n; i++){
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //Inverted Half Pyramid or right angle triangle using nested loops Pattern
    @Test
    void printInvertedHalfPyramid(){
        int n = 4;
        int m = 4;
        for(int i=1; i<=n; i++){
            for (int j=m; j>=i; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //Inverted Half Pyramid (rotated by 180) using nested loops Pattern
    @Test
    void invertedHalfPyramidRotated() {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 1; j <= n-i;  j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i;  j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //Half pyramid with numbers Pattern
    @Test
    void halfPyramidWithNumbers() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //Inverted Half pyramid with numbers Pattern
    @Test
    void invertedHalfPyramidWithNumbers() {
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=1; j <=n-i+1 ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //Floyds Triangle Pattern
    @Test
    void floydsTriangle() {
        int n = 5;
        int number = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    // 0-1 Triangle Pattern
    @Test
    void zeroOneTriangle() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
               if((i+j)%2 == 0)
                   System.out.print("1");
               else
                   System.out.print("0");
            }
            System.out.println();
        }
    }

    //Check if int Array is sorted or not
    @Test
    void checkArrayIsSorted() {
        int[] arr = {1, 4, 3, 6};
        boolean isSorted = true;
        for(int i = 0; i < arr.length-1 ; i++) {
            if(arr[i] > arr[i+1]) {
                isSorted = false;
                break;
            }
        }
        if(isSorted)
            System.out.println("Sorted");
        else
            System.out.println("Not Sorted");
    }

    //Find the maximum & minimum number in an array of integers.
    @Test
    void minAndMaxInArray() {
        int[] arr = {1, 3, 9, 2, 4};
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int number: arr) {
            if (number < smallest){
                smallest = number;
            }
            if (number > largest){
                largest = number;
            }
        }
        System.out.println(smallest + "\n" + largest);
    }


    //Find the largest and smallest substring in a String
    @Test
    void largestAndSmallestSubstring() {
        String s = "tanzania";
        int k = 3;
        String sequence = s.substring(0, k);
        String smallest = sequence;
        String largest = sequence;
        for (int i = 1; i <= (s.length()-k); i++) {
            sequence = s.substring(i, i + k);
            if(sequence.compareTo(smallest) < 0){
                smallest = sequence; }
            if(sequence.compareTo(largest) > 0) {
                largest = sequence;
            }
        }
        System.out.println(smallest + "\n" + largest);
    }

    //Move all Zeroes to the end of array
    @Test
    void moveZerosToEndOfArray() {
        int arr[] = {2,3,0,1,4,1,5,-1};
        int i; //to iterate over array
        int count = 0; //to update the array
        int size = arr.length;
        for(i = 0; i<size; i++) {
            if(arr[i]!=0){
                arr[count] = arr[i]; //shift non-zero elements in the start
                count++;
            }
        }
        while(count<size) {
            arr[count++] = 0; //move all zeroes at the end
        }
        for (i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }



    //Move all Zeroes to the end of arraylist
    @Test
    void moveZerosToEndOfArrayList() {
        ArrayList<Integer> list = new ArrayList<>(List.of(0, 0, 7, 0, 8, 9, 2));
        int i = 0;
        int size = list.size();
        for (Integer value : list)
            if (value != 0) {
                list.set(i, value);
                i++;
            }
        while(i<size) {
            list.set(i++, 0);
        }
        System.out.println(list);
    }

    //2d Array
    @Test
    void array2D() {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        for (int arr1[] : arr) {
            for (int value : arr1) {
                System.out.println(value);
            }
        }
    }

    //search a given number in 2d Array and print indices
    @Test
    void searchIn2dArray() {
        int rows = 2;
        int columns = 3;
        int[][] numbers = {{5,5,6},{5,5,7}};

        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<columns; j++) {
                if(numbers[i][j] == 5) {
                    System.out.print(i +","+ j + " ");
                    //break;
                }
                //break;
            }
            System.out.println();
        }
    }

    //2d Array-Print the spiral order matrix as output for a given matrix of numbers.
    @Test
    void spiralOrderMatrix() {
        int n = 3;
        int[][] numbers = {{1,2,3},{8,9,4},{7,6,5}};

        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        int dir = 0;

        while(top<=down && left<=right) {

            if (dir == 0){
                for(int i=left; i<=right; i++) {
                    System.out.println(numbers[top][i]);
                }
                top+=1;
            }

            else if (dir == 1) {
                for (int i=top; i<=down; i++) {
                    System.out.println(numbers[i][right]);
                }
                right-=1;
            }

            else if (dir == 2) {
                for (int i=right; i>=left; i--) {
                    System.out.println(numbers[down][i]);
                }
                down-=1;
            }

            else if (dir == 3) {
                for (int i=down; i>=top; i--) {
                    System.out.println(numbers[i][left]);
                }
                left+=1;
            }
            dir = (dir+1)%4;
        }
    }

    //2d Array For a given matrix of N x M, print its transpose.
    @Test
    void TransposeOf2dArray() {
        int n = 3;
        int[][] numbers = {{1,2,3},{4,5,6},{7,8,9}};
        int i;
        int j;
        for(i = 0; i<n; i++) {
            for (j = i; j<n; j++)
            {
                if(i != j) {
                    int temp = numbers[i][j];
                    numbers[i][j] = numbers[j][i];
                    numbers[j][i] = temp;
                }
            }

            System.out.println();
        }
        for(i = 0; i<n; i++) {
            for (j = 0; j<n; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Take an array of Strings input & find the cumulative (combined) length of all those strings.
    @Test
    void lengthOfStringArray() {
        String[] arr = {"tony", "stark", "bat", "man"};
        int length = 0;
        for (String value: arr) {
            length += value.length();
        }
        System.out.println(length);
    }

    //Input a string from the user. Create a new string called ‘result’ in which you will replace
    // the letter ‘e’ in the original string with letter ‘i’.
    @Test
    void replaceLetterInString() {
        String str = "abcdf";
        String result = str.replace("e", "i");
        System.out.println(result);
    }

    //create a username by deleting the part that comes after ‘@’
    @Test
    void printSubstring() {
        String email = "apnaCollegeJava@gmail.com";
        String[] arr = email.split("@");
        System.out.println("Your Username is: " + arr[0]);
    }



}
