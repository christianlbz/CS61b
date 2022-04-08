public class ArrayDeque<T> {
    private int head = 0;
    private int tail = 0;
    private T[] itemArray;
    private int size = 0;

    public ArrayDeque(){
        this.itemArray = (T[])new Object[8];
    }

    public boolean isEmpty(){
        return this.head == this.tail;
    }

    public void addFirst(T item){
        if (((tail+1)%itemArray.length) == head){
            System.out.println("The Deque is full.");
            this.addSize();
            this.head = this.itemArray.length-1;
            this.itemArray[this.head] = item;
            this.size += 1;
        } else{
                if (this.head >= 1) {
                    this.head -= 1;
                    itemArray[this.head] = item;
                } else {
                    this.head = itemArray.length - 1;
                    itemArray[this.head] = item;

                }
            this.size += 1;
            }


    }

    public void addLast(T item){
        if(((tail+1)% itemArray.length)==head){
            //System.out.println("The Deque is full.");
            this.addSize();
            this.itemArray[this.tail] = item;
            this.tail += 1;
        } else{
            if(this.tail<= itemArray.length-1){
                itemArray[tail] = item;
                this.tail += 1;
            } else{
                itemArray[0] = item;
                this.tail = 0;
            }
            this.size += 1;
        }
    }

    public T removeFirst(){
        if (this.isEmpty()) {
            System.out.println("The Deque is Empty");
            return null;
        } else {
            T temp = this.itemArray[head];
            this.itemArray[head] = null;
            if (this.head < this.itemArray.length-1){
                this.head += 1;
            } else {
                this.head = 0;
            }
            this.size -= 1;
            if (this.size%7==0){
                this.reduceSize();
            }
            return temp;
        }
    }

    public T removeLast(){
        if (this.isEmpty()){
            System.out.println("The Deque is Empty");
            return null;
        } else {
            T temp;
            if (this.tail > 0){
                this.tail -= 1;
                temp = this.itemArray[this.tail];
                this.itemArray[this.tail] = null;
            } else{
                this.tail = this.itemArray.length-1;
                temp = this.itemArray[this.tail];
                this.itemArray[this.tail] = null;
            }
            this.size -= 1;
            if (this.size%7==0 && this.size != 0){
                this.reduceSize();
            }
            return temp;
        }
    }

    public int size(){
        return this.size;
    }

    public T get(int index){
        if(this.isEmpty()){
            System.out.println("The Deque is Empty");
            return null;
        } else{
            if (index > this.size-1){
                System.out.println("Index of out range");
                return null;
            } else{
                return this.itemArray[(this.head+index)%this.itemArray.length];
            }
        }
    }

    public void printDeque(){
        String string = "";
        for (int i = 0;i<this.size;i++){
            string = string + this.itemArray[(this.head+i)%this.itemArray.length] + " ";
        }
        System.out.println(string);
    }

    private void addSize(){
        int pair = this.itemArray.length - 1;
        T[] newArray = (T[]) new Object[(pair+1)*2+1];
        for(int i = 0;i<this.size;i++){
            newArray[i] = this.itemArray[(this.head+i)%this.itemArray.length];
        }
        this.itemArray = newArray;
        this.head = 0;
        this.tail = this.size;
        //System.out.println("Increment the size of Array.");
    }

    private void reduceSize(){
        int pair = this.itemArray.length - 1;
        T[] newArray = (T[]) new Object[(pair-1)*2+1];
        for (int i = 0;i<this.size;i++){
            newArray[i] = this.itemArray[(this.head+i)%this.itemArray.length];
        }
        this.itemArray = newArray;
        this.head = 0;
        this.tail = this.size;
        //System.out.println("Decrease the size of the Array.");
    }

}
