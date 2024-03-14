// 根据线性表的顺序存储基本运算，设计实现一个算法满足以下操作:
// 1、输出顺序表所有元素
// 2、删除表中某一个元素
// 3、在表中插入一个元素

package yao.zongbin.cn;

public class SequenceList {
    private Object[] array; // 用数组存储元素
    private int size; // 当前元素个数
    private int capacity; // 数组容量

    // 构造函数，初始化顺序表
    public SequenceList(int capacity) {
        this.capacity = capacity;  // 初始化容量
        this.array = new Object[capacity]; //初始化数组存入容量
        this.size = 0; // 初始化元素为0
    }

    // 输出顺序表所有元素
    public void display() {
        for (int i = 0; i < size; i++) {
            //输出数组下标
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 删除表中某一个元素
    public void delete(int index) {
        //检查插入位置的合法性
        //如果插入的位置小于 0 或者大于当前顺序表的大小（即超出了当前元素的范围）
        //则会打印错误信息并返回，不进行插入操作。
        if (index < 0 || index >= size) {
            System.out.println("超出索引值");
            return;
        }
        // 指定索引位置开始，将该位置后面的元素依次向前移动一位
        // 通过这个循环，可以实现删除指定位置的元素
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--; // 将顺序表的大小减一，表示成功删除了一个元素
    }

    // 在表中插入一个元素
    public void insert(int index, Object element) {
        //检查插入位置的合法性
        //如果插入的位置小于 0 或者大于当前顺序表的大小（即超出了当前元素的范围）
        //则会打印错误信息并返回，不进行插入操作。
        if (index < 0 || index > size) {
            System.out.println("超出索引值");
            return;
        }
        //检查顺序表是否已满
        if (size == capacity) {
            System.out.println("顺序表已满");
            return;
        }
        // 从顺序表的最后一个元素开始，依次将插入位置及其后面的所有元素向后移动一位，为新元素腾出位置
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element; // 将新元素插入到指定位置
        size++; // 将顺序表的大小加一，表示成功插入了一个元素
    }

    public static void main(String[] args) {
        SequenceList sequenceList = new SequenceList(10);

        System.out.println(sequenceList.capacity); //输出顺序表容量

        sequenceList.insert(0, "A");
        sequenceList.insert(1, "B");
        sequenceList.insert(2, "C");
        sequenceList.display(); // 输出顺序表所有元素

        sequenceList.delete(1); // 删除元素
        sequenceList.display(); // 输出顺序表所有元素

        sequenceList.insert(1, "D"); // 插入元素
        sequenceList.display(); // 输出顺序表所有元素
    }
}
