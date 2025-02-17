public class App {
    
    static class Sorting {
        int[] dataInt;
        char[] dataChar;
        String[] dataString;

        public Sorting(int[] dataInt, char[] dataChar, String[] dataString) {
            this.dataInt = dataInt;
            this.dataChar = dataChar;
            this.dataString = dataString;
        }

        public void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public void printArray(char[] arr) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        public void printArray(String[] arr) {
            for (String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static class QuickSort extends Sorting {
        public QuickSort(int[] dataInt, char[] dataChar, String[] dataString) {
            super(dataInt, dataChar, dataString);
        }

        private int partition(int[] arr, int low, int high, boolean ascending) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if ((ascending ? arr[j] < pivot : arr[j] > pivot)) {
                    i++;
                    int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                }
            }
            int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
            return i + 1;
        }

        public void quickSort(int[] arr, int low, int high, boolean ascending) {
            if (low < high) {
                int pi = partition(arr, low, high, ascending);
                quickSort(arr, low, pi - 1, ascending);
                quickSort(arr, pi + 1, high, ascending);
            }
        }

        private int partition(char[] arr, int low, int high, boolean ascending) {
            char pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if ((ascending ? arr[j] < pivot : arr[j] > pivot)) {
                    i++;
                    char temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                }
            }
            char temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
            return i + 1;
        }

        public void quickSort(char[] arr, int low, int high, boolean ascending) {
            if (low < high) {
                int pi = partition(arr, low, high, ascending);
                quickSort(arr, low, pi - 1, ascending);
                quickSort(arr, pi + 1, high, ascending);
            }
        }

        private int partition(String[] arr, int low, int high, boolean ascending) {
            String pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if ((ascending ? arr[j].compareTo(pivot) < 0 : arr[j].compareTo(pivot) > 0)) {
                    i++;
                    String temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                }
            }
            String temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
            return i + 1;
        }

        public void quickSort(String[] arr, int low, int high, boolean ascending) {
            if (low < high) {
                int pi = partition(arr, low, high, ascending);
                quickSort(arr, low, pi - 1, ascending);
                quickSort(arr, pi + 1, high, ascending);
            }
        }
    }

    static class InsertionSort extends Sorting {
        public InsertionSort(int[] dataInt, char[] dataChar, String[] dataString) {
            super(dataInt, dataChar, dataString);
        }

        public void insertionSort(int[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i], j = i - 1;
                while (j >= 0 && (ascending ? arr[j] > key : arr[j] < key)) {
                    arr[j + 1] = arr[j]; j--;
                }
                arr[j + 1] = key;
            }
        }

        public void insertionSort(char[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                char key = arr[i]; int j = i - 1;
                while (j >= 0 && (ascending ? arr[j] > key : arr[j] < key)) {
                    arr[j + 1] = arr[j]; j--;
                }
                arr[j + 1] = key;
            }
        }

        public void insertionSort(String[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                String key = arr[i]; int j = i - 1;
                while (j >= 0 && (ascending ? arr[j].compareTo(key) > 0 : arr[j].compareTo(key) < 0)) {
                    arr[j + 1] = arr[j]; j--;
                }
                arr[j + 1] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataInt = {8, 9, 10, 1, 3, 4, 11, 15, 100, 55, 2, 5, 200};
        char[] dataChar = {'v', 'b', 'a', 'z', 'v', 'c', 'f'};
        String[] dataString = {"CODING", "kelas", "XI", "IPA", "I"};

        System.out.println("\nData Asli:");
        System.out.print("Int: ");
        new Sorting(dataInt, dataChar, dataString).printArray(dataInt);
        System.out.print("Char: ");
        new Sorting(dataInt, dataChar, dataString).printArray(dataChar);
        System.out.print("String: ");
        new Sorting(dataInt, dataChar, dataString).printArray(dataString);

        System.out.println("\n=== QuickSort (Descending) ===");
        QuickSort qs = new QuickSort(dataInt.clone(), dataChar.clone(), dataString.clone());
        qs.quickSort(dataInt, 0, dataInt.length - 1, false);
        qs.quickSort(dataChar, 0, dataChar.length - 1, false);
        qs.quickSort(dataString, 0, dataString.length - 1, false);

        System.out.print("Int yang Terurut (Descending): ");
        qs.printArray(dataInt);
        System.out.print("Char yang Terurut (Descending): ");
        qs.printArray(dataChar);
        System.out.print("String yang Terurut (Descending): ");
        qs.printArray(dataString);

        System.out.println("\n=== QuickSort (Ascending) ===");
        qs.quickSort(dataInt, 0, dataInt.length - 1, true);
        qs.quickSort(dataChar, 0, dataChar.length - 1, true);
        qs.quickSort(dataString, 0, dataString.length - 1, true);

        System.out.print("Int yang Terurut (Ascending): ");
        qs.printArray(dataInt);
        System.out.print("Char yang Terurut (Ascending): ");
        qs.printArray(dataChar);
        System.out.print("String yang Terurut (Ascending): ");
        qs.printArray(dataString);

        System.out.println("\n=== Insertion Sort (Descending) ===");
        InsertionSort is = new InsertionSort(dataInt.clone(), dataChar.clone(), dataString.clone());
        is.insertionSort(dataInt, false);
        is.insertionSort(dataChar, false);
        is.insertionSort(dataString, false);

        System.out.print("Int yang Terurut (Descending): ");
        is.printArray(dataInt);
        System.out.print("Char yang Terurut (Descending): ");
        is.printArray(dataChar);
        System.out.print("String yang Terurut (Descending): ");
        is.printArray(dataString);

        System.out.println("\n=== Insertion Sort (Ascending) ===");
        is.insertionSort(dataInt, true);
        is.insertionSort(dataChar, true);
        is.insertionSort(dataString, true);

        System.out.print("Int yang Terurut (Ascending): ");
        is.printArray(dataInt);
        System.out.print("Char yang Terurut (Ascending): ");
        is.printArray(dataChar);
        System.out.print("String yang Terurut (Ascending): ");
        is.printArray(dataString);
    }
}
