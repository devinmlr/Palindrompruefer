public class MyStack<T>{
    
    private Node head;
        
    class Node{
        
        private Node nextNode;
        private T contentObj;
        
        Node(T contentObj){
            nextNode=null;
            this.contentObj=contentObj;
        }
        
        public void setNext(Node nextNode){
            this.nextNode=nextNode;
        }
        
        public Node getNext(){
            return nextNode;
        }
        
        public void setContentObj(T contentObj){
            this.contentObj=contentObj;
        }
        
        public T getContentObj(){
            return contentObj;
        }
        
    }
    
    MyStack(){
        head=null;
    }
    
    public void push(T contentObj){
        Node newNode=new Node(contentObj);
        newNode.setNext(head);
        head=newNode;
    }
    
    public T pop(){
        if (head!=null){
            T topObj=head.getContentObj();
            head=head.getNext();
            return topObj;
        } else {
            return null;
        }
    }
    
    public T top(){
        return head.getContentObj();
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
}
