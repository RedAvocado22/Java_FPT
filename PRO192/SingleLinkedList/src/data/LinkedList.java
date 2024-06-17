package data;

public class LinkedList implements I_LinkedList {

    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void traverse() {
        Node tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public void traverse(int flag) {
        Node tmp = this.head;
        while (tmp != this.tail) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.print(this.tail.val);

    }

    @Override
    public void addTail(int val) {
        Node add = new Node(val);
        if (this.isEmpty()) {
            this.head = add;
            this.tail = add;
        } else {
            this.tail.next = add;
            this.tail = add;
        }
    }

    @Override
    public void addHead(int val) {
        Node add = new Node(val);
        if (this.isEmpty()) {
            this.head = add;
            this.tail = add;
        } else {
            add.next = this.head;
            this.head = add;
        }
    }

    @Override
    public void delHead() {
        if (this.isEmpty()) {
            return;
        }

        this.head = this.head.next;
        if (this.head == null) {
            this.clear();
        }

    }

    @Override
    public void delTail() {
        if (this.isEmpty()) {
            return;
        }

        Node tmp = this.head;
        if (tmp.next == null) {
            this.clear();
        }
        while (tmp.next != this.tail) {
            tmp = tmp.next;
        }
        tmp.next = null;
        this.tail = tmp;

    }

    @Override
    public Node find(int val) {
        Node res = null;
        Node tmp = this.head;
        while (tmp != null) {
            if (tmp.val == val) {
                res = tmp;
                break;
            }
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        Node tmp = this.head;
        int res = 0;
        while (tmp != null) {
            res++;
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public void insert(int index, int val) {

        int n = this.size();
        if (index < 0 || index > n) {
            return;
        }
        if (index == n) {
            this.addTail(val);
        } else if (index == 0) {
            this.addHead(val);
        } else {
            Node tmp = this.head;
            for (int i = 1; i < index; i++) {
                tmp = tmp.next;
            }
            Node next = tmp.next;
            Node newNode = new Node(val);
            tmp.next = newNode;
            newNode.next = next;
        }

    }

    @Override
    public void remove(int index) {
        int n = this.size();
        if (index < 0 || index >= n) {
            return;
        }
        if (index == 0) {
            this.delHead();
        } else if (index == n - 1) {
            this.delTail();
        } else {
            Node tmp = this.head;
            for (int i = 1; i < index; i++) {
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
        }
    }

    @Override
    public void reverse() {
        Node tmp = this.head;
        Node pre = null;
        while (tmp != null) {
            Node next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        tmp = this.head;
        this.head = this.tail;
        this.tail = tmp;
    }

    @Override
    public void addAfter(int target, int val) {
        Node tmp = this.head;
        while (tmp != null && tmp.val != target) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        Node nextNode = tmp.next;
        Node newNode = new Node(val);
        tmp.next = newNode;
        newNode.next = nextNode;

        if (tmp == this.tail) {
            this.tail = newNode;
        }
    }

    @Override
    public void delAfter(int target) {
        Node tmp = this.head;
        while (tmp != null && tmp.val != target) {
            tmp = tmp.next;
        }
        if (tmp == null || tmp == this.tail) {
            return;
        }

        tmp.next = tmp.next.next;
    }

    @Override
    public void addTail(LinkedList list) {
        this.tail.next = list.head;
        this.tail = list.tail;
    }

    @Override
    public void addSorted(int val) {
        if (val <= this.head.val) {
            this.addHead(val);
        } else if (val >= this.tail.val) {
            this.addTail(val);
        } else {
            Node pre = null;
            Node tmp = this.head;
            while (tmp != null && tmp.val < val) {
                pre = tmp;
                tmp = tmp.next;
            }
            Node newNode = new Node(val);
            pre.next = newNode;
            newNode.next = tmp;
        }
    }

    @Override
    public void del(int target) {
        Node pre = null;
        Node tmp = this.head;
        while (tmp != null && tmp.val != target) {
            pre = tmp;
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        if (tmp == this.head) {
            this.delHead();
        } else if (tmp == this.tail) {
            this.delTail();
        } else {
            pre.next = pre.next.next;
        }
    }

    @Override
    public int search(int target) {

        int id = 0;
        Node tmp = this.head;
        while (tmp != null && tmp.val != target) {
            tmp = tmp.next;
            id++;
        }
        if (tmp == null) {
            return -1;
        }
        return id;
    }

    @Override
    public int max() {
        int res = Integer.MIN_VALUE;
        Node tmp = this.head;
        while (tmp != null) {
            res = Math.max(tmp.val, res);
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public int min() {
        int res = Integer.MAX_VALUE;
        Node tmp = this.head;
        while (tmp != null) {
            res = Math.min(tmp.val, res);
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public int sum() {
        int res = 0;
        Node tmp = this.head;
        while (tmp != null) {
            res += tmp.val;
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public double avg() {
        double res = (double) this.sum();
        return res / (double) this.size();
    }

    @Override
    public boolean isSorted() {
        if (this.isEmpty() || this.head == this.tail) {
            return true;
        }
        Node tmp = this.head;
        while (tmp.next != null) {
            if (tmp.next.val < tmp.val) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

    public void swap(Node a, Node b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    @Override
    public void sort() {
        boolean swap = true;
        Node curr = this.head;
        while (swap) {
            swap = false;
            Node tmp = curr;
            while (tmp != null && tmp.next != null) {
                if (tmp.val > tmp.next.val) {
                    swap(tmp, tmp.next);
                    swap = true;
                }
                tmp = tmp.next;
            }
        }
    }

    @Override
    public int[] toArray() {
        int n = this.size();
        int[] res = new int[n];
        Node tmp = this.head;
        for (int i = 0; i < n; i++) {
            res[i] = tmp.val;
            tmp = tmp.next;
        }
        return res;
    }

    @Override
    public LinkedList merge(LinkedList list1, LinkedList list2) {
        LinkedList res = new LinkedList();
        Node tmp1 = list1.head;
        Node tmp2 = list2.head;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                res.addTail(tmp1.val);
                tmp1 = tmp1.next;
            } else {
                res.addTail(tmp2.val);
                tmp2 = tmp2.next;
            }
        }
        while (tmp1 != null) {
            res.addTail(tmp1.val);
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            res.addTail(tmp2.val);
            tmp2 = tmp2.next;
        }
        return res;
    }

    @Override
    public void addBefore(int target, int val) {
        if (this.head.val == target) {
            this.addHead(val);
            return;
        }
        Node pre = null;
        Node tmp = this.head;
        while (tmp != null && tmp.val != target) {
            pre = tmp;
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        Node newNode = new Node(val);
        pre.next = newNode;
        newNode.next = tmp;
    }

    @Override
    public boolean equalsIgnoreOrder(LinkedList list) {
        if (this.size() != list.size()) {
            return false;
        }
        this.sort();
        list.sort();
        Node tmp1 = this.head;
        Node tmp2 = list.head;
        while (tmp1 != null) {
            if (tmp1.val != tmp2.val) {
                return false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return true;

    }

}
