class FrontMiddleBackQueue {
    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    // Helper method to maintain our size rule after every operation
    private void balance() {
        // If left gets too big, move its last element to the front of right
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        } 
        // If right gets too big (difference > 1), move its first element to the back of left
        else if (right.size() > left.size() + 1) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.offerLast(val);
        } else {
            right.offerFirst(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val;
        if (left.isEmpty()) {
            val = right.pollFirst();
        } else {
            val = left.pollFirst();
        }
        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val;
        // If sizes are equal, the middle element is at the end of 'left'
        if (left.size() == right.size()) {
            val = left.pollLast();
        } else {
            // If right is larger, the middle element is at the front of 'right'
            val = right.pollFirst();
        }
        balance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val = right.pollLast();
        balance();
        return val;
    }
}