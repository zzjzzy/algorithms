//实现双向链表
class DoubleLink<T> {
  private Node<T> head; //头结点，不存数据
  private int count;  //节点数
  
  //定义节点内部类
  class Node<T> {
    public T value; //节点值
    public Node<T> prev; //节点的前一个节点
    public Node<T> next; //节点的后一个节点
  }


}
