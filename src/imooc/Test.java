package imooc;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int[] count = new int[256];
        int[] value = new int[256];
        do {
            input = in.nextInt();
            if (input == -1)
                break;
            list.addLast(input);
            if (count[input] == 0)
                linkedList.push(input);
            count[input]++;
        } while (true);


        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int val : linkedList) {
            Node node = new Node();
            node.num = val;
            node.value = count[val];
            heap.add(node);
        }

        while (heap.size() != 1) {
            Node node1 = heap.poll();
            Node node2 = heap.poll();
            Node node = new Node();
            node.value = node1.value + node2.value;
            node.left = node1;
            node.right = node2;
            heap.add(node);
        }

        String[] strs = new String[256];

        Node root = heap.peek();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.getFirst();
            if (node.num != -1) {
                value[node.num] = node.deep;
            }
            queue.removeFirst();
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                node.left.code = node.code + "0";
                queue.addLast(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                node.right.code = node.code + "1";
                queue.addLast(node.right);
            }
            if (node.left == null) {
                strs[node.num] = node.code;
            }
        }

        int pre_result = 0;
        for (int num : linkedList) {
            pre_result += value[num] * count[num];
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str == null)
                sb.append("00000000");
            else {
                sb.append(intToStr(str.length()));
                sb.append(str);
            }
        }
        String bit32 = Integer.toBinaryString(pre_result);
        while (bit32.length() < 32)
            bit32 = "0" + bit32;
        sb.append(bit32);
        for (int num : list) {
            sb.append(strs[num]);
        }
        while (sb.length() % 8 != 0) {
            sb.append('0');
        }
        String bin = sb.toString();
        int pos = 0;
        while (pos <= bin.length() - 8) {
            String b = bin.substring(pos, pos + 8);
            System.out.printf("%s ", Integer.valueOf(b, 2).toString());
            pos += 8;
        }
        System.out.printf("-1\n");
    }

    static String intToStr(int num) {
        String pre_res;
        pre_res = Integer.toBinaryString(num);
        while (pre_res.length() != 8)
            pre_res = "0" + pre_res;
        return pre_res;
    }

}

class Node {
    int num = -1;
    int value;
    int deep = 0;
    Node left = null;
    Node right = null;
    String code = "";
}


