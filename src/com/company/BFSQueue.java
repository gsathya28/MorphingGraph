package com.company;

import java.util.ArrayList;

public class BFSQueue<Object>{

    ArrayList<Object> queue;

    public BFSQueue(){
        queue = new ArrayList<>();
    }

    public boolean enqueue(Object o){
        return queue.add(o);
    }

    public Object dequeue(){
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }

}
