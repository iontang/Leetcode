package divideandconquer;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 *
 * 不存在 {2,2,3,3} 这类数组
 */
public class MajorityElement {
	
	/**
	 * 使用hash的方法，空间复杂度不为O(1)
	 * @param nums
	 * @return
	 */
    public int majorityElement(int[] nums) {
		int f = (int) Math.floor(nums.length/2);
		HashMap<Integer, Integer> h = new HashMap();
		for (Integer num : nums) {
			if (h.containsKey(num)) {
				h.put(num, h.get(num) +1);
			} else {
				h.put(num, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
			if (entry.getValue() > f) {
				return entry.getKey();
			}
		}
		return 0;
    }



    public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		int[] nums ={2,2,3,3};
		System.out.println(majorityElement.majorityElement(nums));

		// java中的向下取整 Math.floor(double a)
		int f = (int) Math.floor(3.2/2);
		// java中的向上取整
		int c = (int) Math.ceil(3.2/2);
	}





}
