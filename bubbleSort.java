class bubbleSort
{
    String[]  sort(String [] arr)
    {
        //String [] arr2;
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    // swap words[i] with words[j[
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
