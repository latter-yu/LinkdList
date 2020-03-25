public class T200325 {

    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        /*myLinedList.addFirst(1);
        myLinedList.addFirst(2);
        myLinedList.addFirst(3);
        myLinedList.addFirst(4);
        myLinedList.display();//4 3 2 1*/

        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(3);
        myLinedList.addLast(2);
        myLinedList.addFirst(2);
        //myLinedList.display();//5 1 2 3 4
        //System.out.println(myLinedList.contains(4));//true
        //System.out.println(myLinedList.size());//5

        myLinedList.removeAllKey(2);
        myLinedList.display();
    }
}
