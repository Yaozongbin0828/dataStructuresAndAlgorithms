//环形队列java案例

import java.util.Scanner;

class circleQueue {
    private int maxSize;// 队列最大容量
    private int front;// 队列头指针
    private int rear;// 队列尾指针
    private int[] arrayQueue;// 队列数组

    public circleQueue(int maxSize) { // 初始化队列
        this.maxSize = maxSize + 1;
        front = 0;
        rear = 0;
        arrayQueue = new int[this.maxSize];
    }

    public boolean isEmpty() { // 判断队列是否为空
        return front == rear;
    }

    public boolean isFull() { // 判断队列是否满了
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int a) { // 入队
        if (!isFull()) {
            arrayQueue[rear % maxSize] = a;
            rear = (rear + 1) % maxSize;
        } else
            System.out.println("队列满了！");
    }

    public int popQueue() { // 出队
        if (!isEmpty()) {
            int temp = arrayQueue[front];
            front = (front + 1) % maxSize;
            return temp;
        } else {
            System.out.println("队列为空！");
            return -1;
        }
    }

    public int getHead() {
        if (!isEmpty()) {
            return arrayQueue[front];
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    public void showQueue() {
        if (!isEmpty()) {
            int count = 0;
            for (int i = front; i < front + getNums(); i++) {
                // 注意要防止下标越界
                System.out.println("Queue[" + count + "]: " + arrayQueue[i % maxSize]);
                count++;
            }
        } else
            System.out.println("队列为空!");
    }

    public int getNums() { // 获取当前队列内有效数据的个数
        return (rear - front + maxSize) % maxSize;
    }
}

class ArrayQueryDemo02 {
    public static void main(String[] args) {
        System.out.print("请输入队列的最大容量:");
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        circleQueue circleQueue = new circleQueue(maxSize);
        boolean isOk = true;
        while (isOk) {
            System.out.println("s(show):显示全部队列");
            System.out.println("a(add):入队");
            System.out.println("p(pop):出队");
            System.out.println("h(getHead):获取队列头");
            System.out.println("e(exit):退出");
            System.out.print("请输入命令: ");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's': {
                    circleQueue.showQueue();
                    break;
                }
                case 'a': {
                    System.out.print("请输入添加数据: ");
                    int add = scanner.nextInt();
                    circleQueue.addQueue(add);
                    System.out.println("入队: " + add);
                    break;
                }
                case 'p': {
                    System.out.println("出队: " + circleQueue.popQueue());
                    break;
                }
                case 'h': {
                    System.out.println("队列头: " + circleQueue.getHead());
                    break;
                }
                case 'e': {
                    System.out.println("退出");
                    isOk = false;
                    break;
                }
                default:
                    System.out.println("输入错误!");
            }
        }
    }
}

