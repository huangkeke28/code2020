package dataStructure0326;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> single = new ArrayList<>();
        if (numRows <= 0) {
            return single;
        }
        if (numRows == 1) {
            List<Integer> x = new ArrayList<>();
            x.add(1);
            single.add(x);
            return single;
        }
        if (numRows == 2) {
            List<Integer> x = new ArrayList<>();
            x.add(1);
            List<Integer> x2 = new ArrayList<>();
            x2.add(1);
            x2.add(1);
            single.add(x);
            single.add(x2);
            return single;
        }
            List<Integer> x = new ArrayList<>();
            x.add(1);
            List<Integer> x2 = new ArrayList<>();
            x2.add(1);
            x2.add(1);
            single.add(x);
            single.add(x2);
            for (int i = 3; i <= numRows; i++) {
                List<Integer> k = new ArrayList<>();
                single.add(k);
                k.add(1);
                for (int j = 1; j < i - 1; j++) {
                    Integer m = single.get(i - 1 - 1).get(j - 1) +single.get(i - 1 - 1).get(j);
                    k.add(m);
                }
                k.add(1);
            }
        return single;
    }

    public List<List<Integer>> generate2(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        for (int row = 3; row <= numRows; row++) {
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 2; col < row; col++) {
                int x = prevLine.get(col - 1)  + prevLine.get(col);
                curLine.add(x);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
