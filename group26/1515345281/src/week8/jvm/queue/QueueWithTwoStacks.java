package week8.jvm.queue;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * @author liuxin
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;    
    private Stack<E> stack2;    

    
    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public boolean isEmpty(){
    	return stack1.size() == 0 && stack2.size() == 0;
    }
   
    public int size(){
    	return stack1.size() + stack2.size();
    }

    public void enQueue(E item){
    	stack1.push(item);
    }
    
    public E deQueue(){
    	if(isEmpty()){
    		throw new NoSuchElementException("Queue is Empty");
    	}
    		
    	if(stack2.isEmpty()){
    		moveStack1ToStack2();
    	}
    	return stack2.pop();
    }
    
    private void moveStack1ToStack2(){
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    }
    
   /* public boolean isEmpty() {
        return stack1.size() == 0; 
    }


    
    public int size() {
        return stack1.size();   
    }



    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
        
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	
    	E object=stack2.pop();
    	
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
    	
    	return object;
    }
*/
 }