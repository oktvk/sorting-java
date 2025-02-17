public class App {

    static class Sorter {
        public Sorter() {
            System.out.println("Pembangun Sorter Dipanggil");
        }

        public void tampilkanData(int[] data) {
            for (int i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public void tampilkanData(char[] data) {
            for (char c : data) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        public void tampilkanData(String[] data) {
            for (String str : data) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static class QuickSortSorter extends Sorter {
        public QuickSortSorter() {
            super();
            System.out.println("Pembangun QuickSortSorter Dipanggil");
        }

        public void quickSort(int[] data, int rendah, int tinggi) {
            if (rendah < tinggi) {
                int pivot = partisi(data, rendah, tinggi);
                quickSort(data, rendah, pivot - 1);
                quickSort(data, pivot + 1, tinggi);
            }
        }

        private int partisi(int[] data, int rendah, int tinggi) {
            int pivot = data[tinggi];
            int i = rendah - 1;
            for (int j = rendah; j < tinggi; j++) {
                if (data[j] <= pivot) {
                    i++;
                    swap(data, i, j);
                }
            }
            swap(data, i + 1, tinggi);
            return i + 1;
        }

        public void quickSort(char[] data, int rendah, int tinggi) {
            if (rendah < tinggi) {
                int pivot = partisi(data, rendah, tinggi);
                quickSort(data, rendah, pivot - 1);
                quickSort(data, pivot + 1, tinggi);
            }
        }

        private int partisi(char[] data, int rendah, int tinggi) {
            char pivot = data[tinggi];
            int i = rendah - 1;
            for (int j = rendah; j < tinggi; j++) {
                if (data[j] <= pivot) {
                    i++;
                    swap(data, i, j);
                }
            }
            swap(data, i + 1, tinggi);
            return i + 1;
        }

        private void swap(int[] data, int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        private void swap(char[] data, int i, int j) {
            char temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    static class InsertionSortSorter extends Sorter {
        public InsertionSortSorter() {
            super();
            System.out.println("Pembangun InsertionSortSorter Dipanggil");
        }

        public void insertionSort(int[] data) {
            for (int i = 1; i < data.length; i++) {
                int kunci = data[i];
                int j = i - 1;
                while (j >= 0 && data[j] > kunci) {
                    data[j + 1] = data[j];
                    j--;
                }
                data[j + 1] = kunci;
            }
        }

        public void insertionSort(char[] data) {
            for (int i = 1; i < data.length; i++) {
                char kunci = data[i];
                int j = i - 1;
                while (j >= 0 && data[j] > kunci) {
                    data[j + 1] = data[j];
                    j--;
                }
                data[j + 1] = kunci;
            }
        }

        public void insertionSort(String[] data) {
            for (int i = 1; i < data.length; i++) {
                String kunci = data[i];
                int j = i - 1;
                while (j >= 0 && data[j].compareTo(kunci) > 0) {
                    data[j + 1] = data[j];
                    j--;
                }
                data[j + 1] = kunci;
            }
        }
    }

    public static void main(String[] args) {
        int[] DATAint = { 8, 9, 10, 1, 3, 4, 11, 15, 100, 55, 2, 5, 200 };
        char[] DATAchar = { 'v', 'b', 'a', 'z', 'v', 'c', 'f' };
        String[] DATAstring = { "CODING", "kelas", "XI", "IPA", "I" };

        System.out.println("Data Awal untuk int[]:");
        Sorter sorter = new Sorter();
        sorter.tampilkanData(DATAint);

        QuickSortSorter quickSort = new QuickSortSorter();
        System.out.println("Data setelah QuickSort Ascending untuk int[]:");
        quickSort.quickSort(DATAint, 0, DATAint.length - 1);
        quickSort.tampilkanData(DATAint);

        InsertionSortSorter insertionSort = new InsertionSortSorter();
        System.out.println("Data setelah InsertionSort Ascending untuk int[]:");
        insertionSort.insertionSort(DATAint);
        insertionSort.tampilkanData(DATAint);

        System.out.println("Data Awal untuk char[]:");
        sorter.tampilkanData(DATAchar);

        System.out.println("Data setelah QuickSort Ascending untuk char[]:");
        quickSort.quickSort(DATAchar, 0, DATAchar.length - 1);
        quickSort.tampilkanData(DATAchar);

        System.out.println("Data setelah InsertionSort Ascending untuk char[]:");
        insertionSort.insertionSort(DATAchar);
        insertionSort.tampilkanData(DATAchar);

        System.out.println("Data Awal untuk String[]:");
        sorter.tampilkanData(DATAstring);

        System.out.println("Data setelah InsertionSort Ascending untuk String[]:");
        insertionSort.insertionSort(DATAstring);
        insertionSort.tampilkanData(DATAstring);
    }
}