class doublelist {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node prev;
        Node (int value){
            this.value=value;
        }
    }

    public doublelist(int value){
        Node newNode= new Node(value);
        head= newNode;
        tail=newNode;
        length=1;
    }

    public void printl(){
        Node temp=head;
        while (temp!=null) {
            System.out.println("value: "+temp.value);
            temp=temp.next;
        }
    }

    public void append(int value){
        Node newnode= new Node(value);
        if(length==0){
            head= newnode;
            tail=newnode;
        }else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        length++;
    }

    public Node remlast() {
        Node temp= tail;
        if(length==0){
           return null;
        }
        if(length==1){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            tail.next=null;
            temp.next=null;
        }
        length--;
        return temp;
    }

    public void pre(int value){
        Node newNode= new Node(value);
        if (length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }

    public Node remfirst(){
        Node temp= head;
        if(length==0) return null;
        if(length==1){
            head=null;
            tail=null;
        }else{
            head=temp.next;
            temp.next=null;
            head.prev=null;
        }
        length--;
        return temp;
    }
    public Node get(int index){
        Node temp;
        if(index<0 || index>=length){
            return null;
        }if(index< length/2){
            temp=head;
           for(int i=0; i< index;i++){
                temp=temp.next;
           }
        }else{
            temp=tail;
            for(int i=length-1;i>index;i-- ){
                temp=temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node tempNode= get(index);
        if(tempNode!= null){
            tempNode.value=value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value){
        if(index <0 || index > length){
            return false;
        }
        if(index==0){
            pre(value);;
            return true;
        }else if(index==length){
            append(value);
            return true;
        }
        Node newNode=new Node(value);
        Node temp=get(index-1);
        Node after=temp.next;
        temp.next=newNode;
        after.prev=newNode;
        newNode.prev=temp;
        newNode.next=after;
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
        Node rem=get(index);
        rem.next.prev=rem.prev;
        rem.prev.next=rem.next;
        rem.next=null;
        rem.prev=null;
        length--;
        return rem;
    }
}
public class doublelinked {
    public static void main(String[] args) {
        doublelist d= new doublelist(7);
        d.append(67);
        d.append(45);
        d.append(46);
        d.pre(44);
        d.remfirst();
        d.set(1, 66);
        d.insert(2, 54);
        d.removNode(3);
        d.printl();
        System.out.println(d.get(2).value);
    }
}
