public class Node<E> {
   public E data;
   public Node<E> next;
   
   Node(E data) {
      this(data, null);
   }
   
   Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
   }
   
   boolean equals(Node<E> node) {
      if(this.data == node.data) {
         return true;
      } 
      return false;
   }

   void print() {
      System.out.println(data + "\n");
   }
}
