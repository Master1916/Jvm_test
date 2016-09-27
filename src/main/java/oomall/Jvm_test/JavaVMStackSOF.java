package oomall.Jvm_test;

/**
 * VM Args: -Xss128k
 * @author Administrator
 *
 */
public class JavaVMStackSOF {
	
	
	public int stackLength=1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	public static void main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.err.println("stack length:"+oom.stackLength);
			e.printStackTrace();
		}
		
		
	}

}
