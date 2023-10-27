import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int length;
        double start;
        double end;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to my sort comparison program.");
        System.out.println("This program compares MergeSort and BubbleSort methods.");
        System.out.println("First, please enter the length of the list you would like sorted.");
        length = scanner.nextInt();

        ArrayList<Integer> newArrayList;
        newArrayList = createRandomArrayList(length);

        System.out.println("Now, which sort method would you like to try? Enter 1 for BubbleSort and 2 for MergeSort.");
        int choice = scanner.nextInt();

        if (choice == 1) {
            start = System.currentTimeMillis();
            bubbleSort(newArrayList);
            end = System.currentTimeMillis();
            for (Integer integer : newArrayList) {
                System.out.println(integer);
            }
            System.out.println("BubbleSort took "+ (end-start) + "milliseconds to sort " + length + " integers.");
        }
        else if (choice == 2){
            start = System.currentTimeMillis();
            mergeSort(newArrayList);
            end = System.currentTimeMillis();
            for (Integer integer : newArrayList) {
                System.out.println(integer);
            }
            System.out.println("MergeSort took "+ (end-start) + "milliseconds to sort " + length + " integers.");
        }
        else {
            System.out.println("Invalid input, please lunch and try again.");
        }
    }

    public static ArrayList<Integer> createRandomArrayList(int arrayLength) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        Random rng = new Random(arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            int rngInt = rng.nextInt(0, 100);
            newArrayList.add(rngInt);
        }
        return newArrayList; 
    }

    public static void bubbleSort (ArrayList<Integer> sArray) {
        bubbleSort(sArray, 0, sArray.size());
    }

    public static void bubbleSort(ArrayList<Integer> sArrayList, int start, int end) {
        if (end - start <= 1)
            return;
        for(int i = start; i < end - 1; i++) {
            if(sArrayList.get(i) > sArrayList.get(i + 1)) {
                int j = i + 1;
                int hold = sArrayList.get(i);
                sArrayList.set(i, sArrayList.get(j));
                sArrayList.set(j, hold);
            }

            bubbleSort(sArrayList, start, end - 1);
        }
    }

    public static void mergeSort(ArrayList<Integer> inputList) {
        if (inputList.size() <= 1) {
            return;
        }

        int middle = inputList.size() / 2;

        ArrayList<Integer> firstHalf = new ArrayList<>(inputList.subList(0, middle));
        ArrayList<Integer> secondHalf = new ArrayList<>(inputList.subList(middle, inputList.size()));

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        mergeSort(inputList, firstHalf, secondHalf);
    }

    public static void mergeSort(ArrayList<Integer> list, ArrayList<Integer> first, ArrayList<Integer> second) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < first.size() && rightIndex < second.size()) {
            if (first.get(leftIndex) < second.get(rightIndex)) {
                list.set(listIndex, first.get(leftIndex));
                leftIndex++;
            } else {
                list.set(listIndex, second.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }

        while (leftIndex < first.size()) {
            list.set(listIndex, first.get(leftIndex));
            leftIndex++;
            listIndex++;
        }

        while (rightIndex < second.size()) {
            list.set(listIndex, second.get(rightIndex));
            rightIndex++;
            listIndex++;
        }
    }
}