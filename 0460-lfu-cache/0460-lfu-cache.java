class LFUCache{
class Node{
int key,val,freq=1;
Node prev,next;
Node(int k,int v){key=k;val=v;}
}
class DLList{
Node head=new Node(0,0);
Node tail=new Node(0,0);
int size=0;
DLList(){
head.next=tail;
tail.prev=head;
}
void add(Node node){
node.next=head.next;
node.prev=head;
head.next.prev=node;
head.next=node;
size++;
}
void remove(Node node){
node.prev.next=node.next;
node.next.prev=node.prev;
size--;
}
Node removeLast(){
if(size>0){
Node node=tail.prev;
remove(node);
return node;
}
return null;
}
}
int capacity,minFreq;
Map<Integer,Node> map;
Map<Integer,DLList> freqMap;
public LFUCache(int capacity){
this.capacity=capacity;
map=new HashMap<>();
freqMap=new HashMap<>();
}
public int get(int key){
if(!map.containsKey(key))return-1;
Node node=map.get(key);
update(node);
return node.val;
}
public void put(int key,int value){
if(capacity==0)return;
if(map.containsKey(key)){
Node node=map.get(key);
node.val=value;
update(node);
}else{
if(map.size()==capacity){
DLList list=freqMap.get(minFreq);
Node removed=list.removeLast();
map.remove(removed.key);
}
Node node=new Node(key,value);
map.put(key,node);
minFreq=1;
freqMap.computeIfAbsent(1,k->new DLList()).add(node);
}
}
private void update(Node node){
int freq=node.freq;
DLList list=freqMap.get(freq);
list.remove(node);
if(freq==minFreq&&list.size==0)minFreq++;
node.freq++;
freqMap.computeIfAbsent(node.freq,k->new DLList()).add(node);
}
}