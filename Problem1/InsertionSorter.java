public class InsertionSorter implements Sorter {

    public InsertionSorter() {
    }

    public int[] Sort(int[] array) {
        System.out.println("Sorting with Insertion Sort.");

        int[] sortedArray = array.clone();


            for (int i = 1; i < sortedArray.length; i++) {
                int tmp = sortedArray[i];
                int j = i - 1;
                
                while (j >= 0 && sortedArray[j] > tmp) {
                    sortedArray[j + 1] = sortedArray[j];
                    j--;
                    sortedArray[j + 1] = tmp;
                }
            }

        return sortedArray;
    }

}
