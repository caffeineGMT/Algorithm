/**
 * LintCode 1179
 * 
 * 分析：本题在于考察基本的联通块计数问题，搜索可行，也可以用并查集。题解采用bfs，如果当前对角线位置为1，开始bfs，如果为2，表示这个人已经搜索统计过了。
 * bfs中的i循环是为了控制当前搜索的点到起点距离相同，j取出队列首个元素，然后k是遍历朋友关系。
 * 如果对角线为1，说明当前这个人位于一个新的联通块内，count++。
 */
public class FriendCircle {
    public int findCircleNum(int[][] M) {
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                count++;
                BFS(i, M);
            }
        }

        return count;
    }

    private void BFS(int student, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(student);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                M[j][j] = 2;

                for (int k = 0; k < M[0].length; k++) {
                    if (M[j][k] == 1 && M[k][k] == 1)
                        queue.add(k);
                }
            }
        }
    }
}
