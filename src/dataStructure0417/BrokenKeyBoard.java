package dataStructure0417;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    public static void main(String[] args) {
        //1.循环读入两个字符串
        //第一个字符串是预期输出的内容 第二个字符串是实际输出的内容
        //2.把读入的字符串全部转换成大写
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String except = scanner.next();
            String actual = scanner.next();
            except = except.toUpperCase();
            actual = actual.toUpperCase();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                char c = actual.charAt(i);
                set.add(c);
            }
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < except.length(); i++) {
                char x = except.charAt(i);
                if (set.contains(x)) {
                    continue;
                }
                if (brokenKey.contains(x)) {
                    continue;
                }
                System.out.print(x);
                brokenKey.add(x);
            } // end for
        } // end while
    }
}
