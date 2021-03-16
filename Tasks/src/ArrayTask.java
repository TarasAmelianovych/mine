public class ArrayTask {
    public static void main(String[] args) {
        int[] array = {4, 3, 9, 7, 2, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] / Math.sqrt(array[i]) == Math.sqrt(array[i])) {
                array[i] /= (int) Math.sqrt(array[i]);
            } else {
                array[i] = (int) Math.pow(array[i], 2);
            }
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
