// 根据线性表的顺序存储基本运算，设计实现一个算法满足以下操作:
// 1、输出顺序表所有元素
// 2、删除表中某一个元素
// 3、在表中插入一个元素

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
        if (index < 0 || index >= size) {
            System.out.println("超出索引值");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // 在表中插入一个元素
    public void insert(int index, Object element) {
        if (index < 0 || index > size) {
            System.out.println("超出索引值");
            return;
        }
        if (size == capacity) {
            System.out.println("顺序表已满");
            return;
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
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
