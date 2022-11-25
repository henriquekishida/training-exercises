public class InsertionSorter implements Sorter {

    public InsertionSorter() {
    }

    public int[] Sort(int[] array) {
        System.out.println("Sorting with Insertion Sort.");

        int[] sortedArray = array.clone();
        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 1; i < sortedArray.length; i++) {
                int tmp = sortedArray[i];
                int j = i - 1;

                if (j >= 0 && sortedArray[j] > tmp) {
                    sortedArray[j + 1] = sortedArray[j];
                    j--;
                    sortedArray[j + 1] = tmp;
                    changed = true;
                }
            }
        }

        return sortedArray;
    }

}
