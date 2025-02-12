class Linked{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    public Linked(int value){
        Node newnode= new Node(value);
        head= newnode;
        tail= newnode;
        length=1;
    }
    public void printl(){
        Node temp=head;
        while (temp!=null) {
            System.out.println("Value: "+temp.value);
            temp=temp.next;
        }
    }
    public void gethead(){
        System.out.println("Head: "+ head.value);
    }

    public void gettail(){
        System.out.println("tail: "+ tail.value);
    }

    public void getlength(){
        System.out.println("length: "+ length);
    }

    public void append(int value){
        Node newnode= new Node(value);
        if(length==0){
            head= newnode;
            tail=newnode;
        }else{
            tail.next=newnode;
            tail=newnode;
        }
        length++;
    }

    public Node remlast(){
        if (length==0){
            return null;
        }
        Node temp=head;
        Node pre=head;
        while (temp.next !=null){
            pre= temp;
            temp=temp.next;
        }
        tail= pre;
        tail.next=null;
        length--;
        if(length==0){
            tail=null;
            head=null;
        }
        return temp;
    }

    public void prep(int value){
        Node newNode = new Node(value);
        if(length==0){
            head= newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }

    public Node remfirst(){
        if(length==0){
            return null;
        }
        Node temp= head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }

    public Node gNode(int index){
        if(index <0 || index >= length){
            return null;
        }
        Node temp=head;
        for(int i=0;i< index; i++){
            temp=temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp= gNode(index);
        if(temp != null){
            temp.value= value;
            return true;
        }
        return false;
    }
    public boolean insert(int index,int value){
        if(index <0 || index > length){
            return false;
        }
        if(index==0){
            prep(value);
            return true;
        }else if(index==length){
            append(value);
            return true;
        }
        Node newnNode=new Node(value);
        Node temp=gNode(index-1);
        newnNode.next=temp.next;
        temp.next=newnNode;
        length++;
        return true;
    }

    public Node removNode(int index){
        if(index <0 || index >= length){
            return null;
        }
        if(index==0){
            return remfirst();
        }else if(index==length-1){
            return remlast();
        }
        Node temp=gNode(index);
        Node prev=gNode(index-1);
        prev.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp=head;
        head=tail;
        tail=temp;
        Node aftNode=temp.next;
        Node befNode=null;
        for (int i=0;i<length;i++){
            aftNode=temp.next;
            temp.next=befNode;
            befNode=temp;
            temp=aftNode;
        }
    }
}
public class linkedlist{
    public static void main(String[] args) {
        Linked l= new Linked(4);
        l.prep(5);
        l.gethead();
        l.append(7);
        l.append(9);
        l.append(23);
        l.append(87);
        l.insert(3, 66);
        l.gettail();
        l.getlength();
        l.remlast();
        l.remfirst();
        l.set(1, 45);
        l.removNode(1);
        l.printl();
        l.reverse();
        l.printl();
        System.out.println("get: "+l.gNode(3));
    }
}