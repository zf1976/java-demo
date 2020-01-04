package collection;

import java.util.ArrayList;
import java.util.List;


public class Node {

    private Node leftNode;
    private Node rightNode;
    // 值
    public Object value;

    public void add(Integer v){
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }

        }
    }

    // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList();

        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.values());

        return values;
    }

    public static void main(String[] args) {
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node node=new Node();
        for(Integer i:randoms){
            node.add(i);
        }
        System.out.println(node.values());
    }
}
