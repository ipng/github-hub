public class Array<E> {
//    private int [] date;
    private E[] date;
    private int size;
    //传入数组的容量capacity构造Array
    public Array(int capacity){
//        date =new int[capacity];
        date = (E[])new Object[capacity];
        size=0;
    }
    //无参数的构造函数，默认数组的容量为10
    public Array(){
        this(10);
    }
    //获取数组中的元素个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getCapacity(){
        return date.length;
    }
    //返回数组是否为空
    public  boolean isEmpty(){
        return size==0;
    }
    //在所以元素后添加一个元素
    public void addLast(E e){
        /*if(size==date.length){
            throw new IllegalArgumentException("AddLast failed")
        }
            data[size]=e;
            size++;*/
        add(size ,e);
    }
    //在头元素添加一个元素
    public  void addFirst(E e){
        add(0,e);
    }
    //在第index个位置中插入一个新的元素
    public void add(int index,E e){

        if (index<0||index>size){
            throw new IllegalArgumentException("Add failed");
        }
        if(size==date.length){
//            throw new IllegalArgumentException("Add failed");
            resize(2*date.length);
        }
        for (int i = size-1; i >=index ; i--)
            date[i + 1] = date[i];
        date[index]=e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData=(E[])new Object[newCapacity];
        for (int i = 0; i <size ; i++) {
            newData[i] =date[i];
        }
        date=newData;
    }

    //获取index索引位置的元素
     public E get(int index) {
         if (index < 0 || index >= size) {
             throw new IllegalArgumentException("index failed");
         }
         return date[index];
     }
         public void set(int index, E e){
             if((index < 0) || (index >= size)){
                 throw new IllegalArgumentException("index failed");
             }
             date[index]=e;
    }
    public  E getLast(){
        return get(size-1);
    }
    public  E getFirst(){
        return get(0);
    }
    //查找数组中是否有元素e
    public boolean cantains(E e){
        for (int i = 0; i <size ; i++) {
            if (date[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //如果不存在元素E，则返回-1
    public int fine(E e){
        for (int i = 0; i <size ; i++) {
            if (date.equals(e)){
                return i;
            }
        }
        return -1;
    }
    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed");
        }
       E ret =date[index];
        for (int i = index+1; i <size ; i++) {
            date[i-1]= date[i];
        }
        size--;

        if (size==date.length/2){
            resize(date.length/2);
        }
        return ret;
    }
    //删除第一个元素
    public E remoceFirst(){

        return remove(0);
    }
    //删除最后一个元素
    public E removeLast(){
        return  remove(size-1);
    }
    //删除数组中的元素e
    public void removeElement(E e){
        int index =fine(e);
        if (index!=-1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder res =new StringBuilder();
        res.append(String.format("Array:size=%d, capacity=%d\n",size,date.length));
        res.append('[');
        for (int i = 0; i <size ; i++) {
            res.append(date[i]);
            if (i!=size-1){
                res.append(',');
            }
        }
        res.append(']');
        return  res.toString();
    }
}
