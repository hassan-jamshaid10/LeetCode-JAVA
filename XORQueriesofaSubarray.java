class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int m = queries.length;
    int[] prefixXOR = new int[n + 1];
    
    for (int i = 0; i < n; i++) {
        prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
    }
    
    int[] result = new int[m];
    for (int i = 0; i < m; i++) {
        int left = queries[i][0];
        int right = queries[i][1];
        result[i] = prefixXOR[right + 1] ^ prefixXOR[left];
    }
    
    return result;
}

}