package year.year_2020.month_03.problems_20200316.Reorder_Data_in_Log_Files;

public class QuickSortSolution {

    public String[] reorderLogFiles(String[] logs) {
        String[] reordered = new String[logs.length];
        int front = 0;
        int back = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String log = logs[i];
            if (isLetter(log)) {
                reordered[front] = log;
                front++;
            } else {
                reordered[back] = log;
                back--;
            }
        }
        quicksort(reordered, 0, front - 1);
        return reordered;
    }

    private boolean isLetter(String log) {
        char first = log.charAt(log.indexOf(' ') + 1);
        return first >= 'a' && first <= 'z';
    }

    private void quicksort(String[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quicksort(arr, left, index - 1);
        }
        if (index < right) {
            quicksort(arr, index, right);
        }
    }

    private int partition(String[] arr, int left, int right) {
        String pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (compare(arr[left], pivot) && !arr[left].equals(pivot)) {
                left++;
            }
            while (compare(pivot, arr[right]) && !arr[right].equals(pivot)) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private boolean compare(String left, String right) {
        int leftLen = left.length();
        int rightLen = right.length();
        int leftStart = left.indexOf(' ') + 1;
        int rightStart = right.indexOf(' ') + 1;
        int len = Math.min(leftStart - 1, rightStart - 1);
        while (leftStart < leftLen && rightStart < rightLen) {
            int leftLetter = left.charAt(leftStart);
            int rightLetter = right.charAt(rightStart);
            if (leftLetter > rightLetter) {
                return false;
            } else if (leftLetter < rightLetter) {
                return true;
            }
            leftStart++;
            rightStart++;
        }
        if (leftLen > rightLen) {
            return false;
        } else if (leftLen == rightLen) {
            for (int i = 0; i < len; i++) {
                int leftLetter = left.charAt(i);
                int rightLetter = right.charAt(i);
                if (leftLetter > rightLetter) {
                    return false;
                } else if (leftLetter < rightLetter) {
                    return true;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    private void swap(String[] arr, int left, int right) {
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
