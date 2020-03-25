class Node {
    //Node: 节点(有data（保存数据）、next（保存下一个节点的地址（引用））)
    public int data;
    public Node next;//Node也是类型(引用)

    public Node(int data) {
        this.data = data;//初始化
        //next初始化只能为null，无意义
    }
}

//单链表
public class MyLinedList {
    //链表是一种物理存储结构上非连续存储结构
    //数据元素的逻辑顺序是通过链表中的引用链接次序实现的
    //实际中链表的结构非常多样，以下情况组合起来就有6种链表结构：
    //单向、双向、带头、不带头、循环、非循环
    //无头单向非循环链表：结构简单，一般不会单独用来存数据。实际中更多是作为其他数据结构的子结构
    //无头双向链表：在Java的集合框架库中LinkedList底层实现就是无头双向循环链表

    public Node head;
    //无头单向非循环链表实现

    public MyLinedList(Node head) {
        this.head = null;
    }

    public MyLinedList() {

    }

    //头插法 99
    public void addFirst(int data) {
        //1.先拿到一个节点
        Node node = new Node(data);

        if(this.head == null) {
            //第一次插入节点
            this.head = node;
            return;
        }

        //2.把它插入到head前面
        node.next = this.head;//head = null
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);

        if(this.head == null) {
            //第一次插入节点
            this.head = node;
            return;
        }

        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        //cur指向节点尾巴
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        //Index: 要插入的节点名称
        if (index < 0 || index > size()) {
            throw new RuntimeException("index位置不合法");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        //1.让cur找到Index的前一个
        Node prev = findIndex(index);
        //2.先换node的地址，再换Index的前一个的地址
        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;
    }
    private Node findIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    private Node findPrev(int key) {
        //找要找节点的前一个节点prev
        Node prev = this.head;
        while (prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void remove(int key) {
        //prev为要删除节点的前一个;del为要删除的节点
        Node prev = findPrev(key);

        //如果要删除的节点为头节点：
        if(key == this.head.data) {
            this.head =head.next;
            return;
        }
        //如果找不到要删除的节点：
        if(prev == null) {
            System.out.println("没有这个节点");
            return;
        }
        //如果找到了,则直接跳过del节点为删除：
        Node del = prev.next;
        prev.next = del.next;
    }

    //删除所有 值为key的节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;//prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }
    public void clear() {

    }
}
