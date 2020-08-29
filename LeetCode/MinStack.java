/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks. */

public class MinStack {

    /** initialize your data structure here. */
    private Node head;
    private int min;

    public MinStack() {
        head = null;
        min = 0;
    }

    public void push(int x) {
        // create new Node and link the "first" reference to this new Node
        if (head == null) {
            Node data = new Node(x);
            head = data;
        } else {
            Node data = new Node(x);
            data.next = head;
            head = data;
        }

    }

    public void pop() {
        // redirect head reference, and remove the popped node from heap memory
        Node temp = head;
        head = head.next;
    }

    public int top() {
        // return the value from head reference
        return head.value;
    }

    public int getMin() {
        if (head == null) {
            throw new Error("empty minStack");
        }
        return min;
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */