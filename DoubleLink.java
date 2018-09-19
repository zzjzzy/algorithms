//实现双向链表
class DoubleLink<T> {
  private Node<T> head; //头结点，不存数据
  private int count;  //节点数
  
  //定义节点内部类
  class Node<T> {
    public T value; //节点值
    public Node<T> prev; //节点的前一个节点
    public Node<T> next; //节点的后一个节点
    
    //构造函数初始化节点
    public Node(T value, Node<T> prev, Node<T> next){
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }
  
  //初始化链表
  public DoubleLink(){
    head = new Node(null, null, null);
    head.prev = head.next = head;
  }
  
  //获得指定index的节点，外部一般获取节点值，获取节点没意义，所以定义为private
  private Node<T> getNode(int index){
    //如果index在前半部分，就用前序遍历
    if(index <= count/2){
      Node<T> node = head.next;
      for(int i = 0; i < index; i++){
        node = node.next;
      }
      return node;
    }
    
    //如果index在后半部分，就用后序遍历
    Node<T> node = head.prev;
    rindex = count - 1 - index;
    for(int i = 0; i < rindex; i++){
      node = node.prev;
    }
    return node;
  }


}
