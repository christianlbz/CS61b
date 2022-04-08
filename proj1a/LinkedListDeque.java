public class LinkedListDeque<T> {
    public class Node<T> {
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    private Node setinel = new Node(null, null, null);
    private int size = 0;

    public LinkedListDeque(){
        setinel.pre = setinel;
        setinel.next = setinel;
    }

    public void addFirst(T item){
        if (setinel.next.item == null){
            Node temp = new Node(item, setinel, setinel);
            setinel.next = temp;
            setinel.pre = temp;
        } else {
            Node temp = setinel.next;
            setinel.next = new Node(item, setinel, temp);
            temp.pre = setinel.next;
        }
        this.size += 1;
    }

    public void addLast(T item){
        if (setinel.pre.item == null){
            Node temp = new Node(item, setinel, setinel);
            setinel.pre = temp;
            setinel.next = temp;
        } else{
            Node temp = setinel.pre;
            setinel.pre = new Node(item, temp, setinel);
            temp.next = setinel.pre;
        }
        this.size += 1;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public T removeFirst(){
        if(setinel.next.item == null){
            return null;
        } else {
            T val = (T) setinel.next.item;
            if (setinel.next.next.item == null){
                setinel.next = setinel;
                setinel.pre = setinel;
            } else{
                setinel.next = setinel.next.next;
                setinel.next.pre = setinel;
            }
            this.size -= 1;
            return val;
        }
    }

    public T removeLast(){
        if (setinel.pre.item == null){
            return null;
        } else {
            T val = (T) setinel.pre.item;
            if (setinel.pre.pre.item == null){
                setinel.next = setinel;
                setinel.pre = setinel;
            } else{
                setinel.pre = setinel.pre.pre;
                setinel.pre.next = setinel;
            }
            this.size -= 1;
            return val;
        }
    }

    public T get(int index){
        if (index > this.size-1){
            System.out.println("index out of range");
            return null;
        } else{
            Node temp = setinel.next;
            while(index != 0){
                temp = temp.next;
                index -= 1;
            }
            return (T) temp.item;
        }
    }

    public T getRecursive(int index){
        if (index > this.size-1){
            System.out.println("index out of range");
            return null;
        } else{
            Node temp = setinel.next;
            while(index != 0){
                temp = temp.next;
                index -= 1;
            }
            return (T) temp.item;
        }
    }


    public void printDeque(){
        String string = "";
        Node temp = setinel.next;
        while(temp != setinel){
            string = string + temp.item + " ";
            temp = temp.next;
        }
        System.out.println(string);
    }



}
