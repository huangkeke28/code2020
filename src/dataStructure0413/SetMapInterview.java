package dataStructure0413;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SetMapInterview {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue().equals(1)) {
//                return entry.getValue();
//            }
//        }
        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue().equals(1)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public int[] singleNumber2(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                //第一组 指定位为1
                a ^= x;
            } else {
                //第二组 指定位为0
                b ^= x;
            }
        }
        int[] array = {a, b};
        return array;
    }

    public int singNumber11(int[] nums) {
        //用哈希表来实现 value 中存出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
//        //遍历
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue().equals(1)) {
//                return entry.getValue();
//            }

        //迭代器
        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue().equals(1)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public int[] singleNubers22(int[] array) {
        int ret = 0;
        for (int x : array) {
            ret ^= x;
        }
        int i = 0;
        int bit = 1;
        for(; i < 32; i++) {
            if ((ret & (1 << i)) != 0) {
                break;
            }
        }
        int a = 0;
        int b= 0;
        for (int x : array) {
            if ((x & (bit << i)) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int num[] = {a, b};
        return num;
    }
}
