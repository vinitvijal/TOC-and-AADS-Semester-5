public class RandomizedSelect {
    public static void main(String[] args) {
        int[] arr = { 12, 3, 5, 7, 4, 19, 26 };
        int k = 3;
        System.out.println("K'th smallest element is " + randomizedSelect(arr, 0, arr.length - 1, k));
    }

    public static int randomizedSelect(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }
        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if (i == k) {
            return arr[q];
        } else if (i < k) {
            return randomizedSelect(arr, p, q - 1, i);
        } else {
            return randomizedSelect(arr, q + 1, r, i - k);
        }
    }

    public static int randomizedPartition(int[] arr, int p, int r) {
        int i = (int) (Math.random() * (r - p + 1) + p);
        swap(arr, i, r);
        return partition(arr, p, r);
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
