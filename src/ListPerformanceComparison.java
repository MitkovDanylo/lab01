import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceComparison {

    public static void main(String[] args) {
        int listSize = 100000;
        int elementsToInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Fill
        measureTime(() -> fill(arrayList, listSize, "ArrayList"), "Fill ArrayList");
        measureTime(() -> fill(linkedList, listSize, "LinkedList"), "Fill LinkedList");

        // Random Access
        measureTime(() -> randomAccess(arrayList, "ArrayList"), "Random access in ArrayList");
        measureTime(() -> randomAccess(linkedList, "LinkedList"), "Random access in LinkedList");

        // Sequential Access
        measureTime(() -> sequentialAccess(arrayList, "ArrayList"), "Sequential access in ArrayList");
        measureTime(() -> sequentialAccess(linkedList, "LinkedList"), "Sequential access in LinkedList");

        // Insert at the beginning
        measureTime(() -> insertAtBeginning(arrayList, elementsToInsert, "ArrayList"), "Insert at the beginning of ArrayList");
        measureTime(() -> insertAtBeginning(linkedList, elementsToInsert, "LinkedList"), "Insert at the beginning of LinkedList");

        // Insert at the end
        measureTime(() -> insertAtEnd(arrayList, elementsToInsert, "ArrayList"), "Insert at the end of ArrayList");
        measureTime(() -> insertAtEnd(linkedList, elementsToInsert, "LinkedList"), "Insert at the end of LinkedList");

        // Insert in the middle
        measureTime(() -> insertInMiddle(arrayList, elementsToInsert, "ArrayList"), "Insert in the middle of ArrayList");
        measureTime(() -> insertInMiddle(linkedList, elementsToInsert, "LinkedList"), "Insert in the middle of LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt());
        }
    }

    private static void randomAccess(List<Integer> list, String listType) {
        Random random = new Random();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(size);
            list.get(index);
        }
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        for (Integer value : list) {
            // Sequential access, do nothing
        }
    }

    private static void insertAtBeginning(List<Integer> list, int count, String listType) {
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
    }

    private static void insertAtEnd(List<Integer> list, int count, String listType) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static void insertInMiddle(List<Integer> list, int count, String listType) {
        int size = list.size();
        for (int i = 0; i < count; i++) {
            int index = size / 2;
            list.add(index, i);
        }
    }

    private static void measureTime(Runnable operation, String operationName) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.printf("%s: %d ms%n", operationName, endTime - startTime);
    }
}
