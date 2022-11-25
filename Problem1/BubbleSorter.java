public class BubbleSorter implements Sorter {

    public BubbleSorter() {
    }

    public int[] Sort(int[] array) {
        System.out.println("Sorting array using Bubble Sort");
        int[] sortedArray = array.clone();
        boolean moved = true;

        while (moved) {
            moved = false;
            
            for (int i = 0; i < sortedArray.length - 1; i++) {
                int tmp = sortedArray[i];
                if (sortedArray[i] > sortedArray[i + 1]) {
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = tmp;
                    moved = true;
                }
            }
        }

        return sortedArray;
    }
}
