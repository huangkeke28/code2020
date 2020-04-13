package dataStructure0413;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("Java");
        System.out.println(set.contains("World"));
        set.remove("World");
        System.out.println(set.contains("World"));
        System.out.println(set);
        //如果想要循环遍历set中的元素，就需要使用迭代器
        //迭代器中的泛型参数要和集合类中保存的元素参数一致
        //集合类内部自己实现自己版本的迭代器类  不同的集合类 内部的迭代器类型不同
        //迭代方式也不同
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next= iterator.next();
            System.out.println(next);
        }
        //Map 和 Set 元素组织顺序和插入顺序没有任何关系
    }
}
