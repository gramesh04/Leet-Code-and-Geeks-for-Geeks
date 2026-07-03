class Skiplist {
    class Node {
        int val;
        Node[] next;
        Node(int val,int level){
            this.val=val;
            next=new Node[level];
        }
    }

    private static final int MAX_LEVEL=16;
    private final Node head=new Node(-1,MAX_LEVEL);
    private int level=1;

    public Skiplist() {}

    public boolean search(int target) {
        Node curr=head;
        for(int i=level-1;i>=0;i--){
            while(curr.next[i]!=null&&curr.next[i].val<target){
                curr=curr.next[i];
            }
        }
        curr=curr.next[0];
        return curr!=null&&curr.val==target;
    }

    public void add(int num) {
        Node[] update=new Node[MAX_LEVEL];
        Node curr=head;
        for(int i=level-1;i>=0;i--){
            while(curr.next[i]!=null&&curr.next[i].val<num){
                curr=curr.next[i];
            }
            update[i]=curr;
        }
        int newLevel=randomLevel();
        if(newLevel>level){
            for(int i=level;i<newLevel;i++) update[i]=head;
            level=newLevel;
        }
        Node node=new Node(num,newLevel);
        for(int i=0;i<newLevel;i++){
            node.next[i]=update[i].next[i];
            update[i].next[i]=node;
        }
    }

    public boolean erase(int num) {
        Node[] update=new Node[MAX_LEVEL];
        Node curr=head;
        for(int i=level-1;i>=0;i--){
            while(curr.next[i]!=null&&curr.next[i].val<num){
                curr=curr.next[i];
            }
            update[i]=curr;
        }
        curr=curr.next[0];
        if(curr==null||curr.val!=num) return false;
        for(int i=0;i<level;i++){
            if(update[i].next[i]!=curr) break;
            update[i].next[i]=curr.next[i];
        }
        while(level>1&&head.next[level-1]==null) level--;
        return true;
    }

    private int randomLevel() {
        int lvl=1;
        while(Math.random()<0.5&&lvl<MAX_LEVEL) lvl++;
        return lvl;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */