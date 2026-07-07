class LRUCache {
    private class Node
    {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val)
        {
            this.key= key;
            this.val= val;
            next= this;
            prev= this;
        }
    }
    
    HashMap<Integer, Node> map;
    int cap, count=0;
    Node head;

    public LRUCache(int capacity) {
        cap= capacity;
        map= new HashMap<>();
    }
    
    public int get(int key) {
        Node node= map.getOrDefault(key, null);
        if(node==null)
            return -1;

        if(node==head)
        {
            head= head.next;
            return node.val;
        }

        Node before= node.prev;
        Node ahead= node.next;
        before.next= ahead;
        ahead.prev= before;

        Node tail= head.prev;
        tail.next= node;
        node.prev= tail;
        node.next= head;
        head.prev= node;
        return node.val; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node= map.get(key);
            node.val= value;

            if(node==head)
            {
                head= head.next;
                return;
            }

            Node before= node.prev;
            Node ahead= node.next;
            before.next= ahead;
            ahead.prev= before;

            Node tail= head.prev;
            tail.next= node;
            node.prev= tail;
            
            node.next= head;
            head.prev= node;
            return;
        }

        Node node= new Node(key, value);

        if(head==null)
        {
            map.put(key, node);
            head= node;
            count++;
            return;
        }

        if(count != cap)
        {
            map.put(key, node);
            Node tail= head.prev;

            tail.next= node;
            node.prev= tail;
            
            node.next= head;
            head.prev= node;
            count++;
            return;
        }

        map.remove(head.key);
        map.put(key, head);
        head.key= key;
        head.val= value;
        head= head.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */