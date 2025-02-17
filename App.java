public class App {

    static class InsertionSorter extends Sorter {
        public InsertionSorter(int[] integers, char[] characters, String[] strings) {
            super(integers, characters, strings);
        }

        public void insertionSort(String[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                String key = arr[i];
                int j = i - 1;
                while (j >= 0 && (ascending ? arr[j].compareTo(key) > 0 : arr[j].compareTo(key) < 0)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

        public void insertionSort(int[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i], j = i - 1;
                while (j >= 0 && (ascending ? arr[j] > key : arr[j] < key)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

        public void insertionSort(char[] arr, boolean ascending) {
            for (int i = 1; i < arr.length; i++) {
                char key = arr[i];
                int j = i - 1;
                while (j >= 0 && (ascending ? arr[j] > key : arr[j] < key)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
    }

    static class QuickSorter extends Sorter {
        public QuickSorter(int[] integers, char[] characters, String[] strings) {
            super(integers, characters, strings);
        }

        public void quickSort(String[] arr, int low, int high, boolean ascending) {
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
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        public void quickSort(int[] arr, int low, int high, boolean ascending) {
            if (low < high) {
                int pi = partition(arr, low, high, ascending);
                quickSort(arr, low, pi - 1, ascending);
                quickSort(arr, pi + 1, high, ascending);
            }
        }

        private int partition(int[] arr, int low, int high, boolean ascending) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if ((ascending ? arr[j] < pivot : arr[j] > pivot)) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        private void swap(String[] arr, int i, int j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void quickSort(char[] arr, int low, int high, boolean ascending) {
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
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }
    }

    static class Sorter {
        int[] integers;
        char[] characters;
        String[] strings;

        public Sorter(int[] integers, char[] characters, String[] strings) {
            this.integers = integers;
            this.characters = characters;
            this.strings = strings;
        }

        public void display(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public void display(char[] arr) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        public void display(String[] arr) {
            for (String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] integers = {8, 9, 10, 1, 3, 4, 11, 15, 100, 55, 2, 5, 200};
        char[] characters = {'v', 'b', 'a', 'z', 'v', 'c', 'f'};
        String[] strings = {"CODING", "kelas", "XI", "IPA", "I"};

        System.out.println("\nData Asli:");
        System.out.print("Int: ");
        new Sorter(integers, characters, strings).display(integers);
        System.out.print("Char: ");
        new Sorter(integers, characters, strings).display(characters);
        System.out.print("String: ");
        new Sorter(integers, characters, strings).display(strings);

        System.out.println("\n=== QuickSort (Descending) ===");
        QuickSorter quickSorter = new QuickSorter(integers.clone(), characters.clone(), strings.clone());
        quickSorter.quickSort(integers, 0, integers.length - 1, false);
        quickSorter.quickSort(characters, 0, characters.length - 1, false);
        quickSorter.quickSort(strings, 0, strings.length - 1, false);

        System.out.print("Int yang Terurut (Descending): ");
        quickSorter.display(integers);
        System.out.print("Char yang Terurut (Descending): ");
        quickSorter.display(characters);
        System.out.print("String yang Terurut (Descending): ");
        quickSorter.display(strings);

        System.out.println("\n=== QuickSort (Ascending) ===");
        quickSorter.quickSort(integers, 0, integers.length - 1, true);
        quickSorter.quickSort(characters, 0, characters.length - 1, true);
        quickSorter.quickSort(strings, 0, strings.length - 1, true);

        System.out.print("Int yang Terurut (Ascending): ");
        quickSorter.display(integers);
        System.out.print("Char yang Terurut (Ascending): ");
        quickSorter.display(characters);
        System.out.print("String yang Terurut (Ascending): ");
        quickSorter.display(strings);

        System.out.println("\n=== Insertion Sort (Descending) ===");
        InsertionSorter insertionSorter = new InsertionSorter(integers.clone(), characters.clone(), strings.clone());
        insertionSorter.insertionSort(integers, false);
        insertionSorter.insertionSort(characters, false);
        insertionSorter.insertionSort(strings, false);

        System.out.print("Int yang Terurut (Descending): ");
        insertionSorter.display(integers);
        System.out.print("Char yang Terurut (Descending): ");
        insertionSorter.display(characters);
        System.out.print("String yang Terurut (Descending): ");
        insertionSorter.display(strings);

        System.out.println("\n=== Insertion Sort (Ascending) ===");
        insertionSorter.insertionSort(integers, true);
        insertionSorter.insertionSort(characters, true);
        insertionSorter.insertionSort(strings, true);

        System.out.print("Int yang Terurut (Ascending): ");
        insertionSorter.display(integers);
        System.out.print("Char yang Terurut (Ascending): ");
        insertionSorter.display(characters);
        System.out.print("String yang Terurut (Ascending): ");
        insertionSorter.display(strings);
    }
}
