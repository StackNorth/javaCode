package cn.bjsxt.collection;
/**
 * 掌握链表，理解
 * @author llf
 *
 */
public class SxtLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj){
		Node n = new Node();
		if(first == null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			first = n;
			last = n;
		}else{//直接往last节点后增加新的节点；
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public Object get(int index){
		rangeChex(index);
		Node temp = node(index);
		if(temp != null){
			return temp.obj;
		}
		return null;
	}
	
	public void remove(int index){
		Node temp = node(index);
		if(temp != null){
			Node up = temp.previous;
			Node down = temp.next;
			up.next = down;
			down.previous = up;
			size--;
		}
	} 
	
	private void rangeChex(int index){
		if( index >= size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public Node node (int index){
		Node temp = null;
		if(first != null){
			if(size<(index >> 1)){ 
				temp = first;
				for(int i = 0;i < index;i++){
					temp = temp.next; 
				}
			}else{
				temp = last;
				for(int i = size-1;i > index;i--){
					temp = temp.previous; 
				}
			}//提高效率
				
		}
		return temp; 
	}
	
	public void add(int index, Object obj){
		Node temp = node(index);
		Node newnode = new Node();
		newnode.obj = obj;
		if(temp != null){
			Node up = temp.previous;
			up.next = newnode;
			newnode.previous = up;
			newnode.next = temp;
			temp.previous = newnode;
			
			size++;
		}
	}
	
	public static void main(String[] args) {
		SxtLinkedList list = new  SxtLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add(1,"BBB");
		list.add("ccc");
//		list.remove(1);
		System.out.println(list.get(1));
	}
	
	
}

