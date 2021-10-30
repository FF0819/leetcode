import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return -1;
        }
        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equals("0000")) {
                return -1;
            }
            deadendSet.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer("0000");
        seen.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : getNextStatus(status)) {
                    if (nextStatus.equals(target)) {
                        return step;
                    }
                    if (!seen.contains(nextStatus) && !deadendSet.contains(nextStatus)) {
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private static List<String> getNextStatus(String status) {
        List<String> nextStatusList = new ArrayList<>();
        char[] charArray = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = charArray[i];
            charArray[i] = numPrev(c);
            nextStatusList.add(String.valueOf(charArray));
            charArray[i] = numSucc(c);
            nextStatusList.add(String.valueOf(charArray));
            charArray[i] = c;
        }
        return nextStatusList;
    }

    private static char numSucc(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    private static char numPrev(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }
}
