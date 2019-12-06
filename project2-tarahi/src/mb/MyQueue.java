package mb;

public class MyQueue {
	
	public Node front;
	public Node rear;
	
	public MyQueue() 
	{
		front = null;
		rear = null;
	}
	
	public void enqueue(int x)
	{
		Node p= new Node();
		p.info = x;
		p.next = null;
		if(rear == null)
			front = rear = p;
		else
		{
			rear.next = p;
			rear = p;
		}
	}
	
	public int dequeue()
	{
		int x;
		if(rear !=null){
			x = front.info;
			front = front.next;
			return x;
			
		}
		return-1;
		
		
	}

}
