package leetcode454;
import java.util.HashMap;
//454, 4sum 2
// 时间复杂度： O(n^2)
// 空间复杂度： O(n^2)
public class Solution1 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
		if(A == null || B == null || C == null || D == null){
			throw new IllegalArgumentException("Illegal argument");
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < C.length; i++){
			for(int j = 0; j < D.length; j++){
				int sum = C[i] + D[j];
				if (map.containsKey(sum)){
					map.put(sum, map.get(sum)+1);
				}else {
					map.put(sum, 1);
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j<B.length; j++){
				if (map.containsKey(-A[i]-B[j])){
					result += map.get(-A[i]-B[j]);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution1()).fourSumCount(a, b, c, d));
    }

}
