//顺序表的各个操作
public class SeqList {
    private int[] data;
    private int length;
    private int capacity;

    //初始化数值
    public SeqList(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.length = 0;
    }

    //插入元素
    public void insert(int index, int element) {
        //检查插入位置的合法性
        //如果插入的位置小于 1 或者大于当前顺序表的大小（即超出了当前元素的范围）
        //则会打印错误信息并返回，不进行插入操作。
        if (index < 1 || index > length + 1 || length >= capacity) {
            System.out.println("插入失败");
            return;
        }
        // 从顺序表的最后一个元素开始，依次将插入位置及其后面的所有元素向后移动一位，为新元素腾出位置
        // int i = length-1
        for (int i = length; i >= index; i++) {
            data[i] = data[i - 1];
//            data[i - 1] = data[i] ;
        }

        data[index - 1] = element; // 将新元素插入到指定位置
        length++;// 将顺序表的大小加一，表示成功插入了一个元素
    }

    //删除元素
    public void delete(int index) {

        if (index < 1 || index > length) {
            System.out.println("删除失败");
            return;
        }
        for (int i = index - 1; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
    }

    //查找元素
    public int find(int element) {
        for (int i = 0; i < length; i++) {
            if (data[i] == element) {
                return i + 1; //返回元素的位置（从1开始计数）
            }
        }
        //元素不存在返回-1
        return -1;
    }

    //打印
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    //获取顺序表的长度
    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        SeqList seqList = new SeqList(10);
        System.out.println("初始长度为"+seqList.getLength()); //长度为0
        seqList.insert(1,1);
        seqList.insert(2,2);
        seqList.insert(3,3);
        seqList.insert(4,4);

        System.out.println("插入后长度为"+seqList.getLength()); //长度为4
        seqList.print(); //1,2,3,4
        System.out.println("查找元素2："+seqList.find(2));//查找元素2 返回2
        seqList.delete(2);//删除位置2的元素
        seqList.print();// 1,3,4
        System.out.println("删除后长度为"+seqList.getLength()); //长度为3
    }
}
