package oomall.Jvm_test;

/**
 * VM Args: -Xss2m 
 * 在运行此类的过程中可能造成系统假死 要做好工作区备份或是关闭工作区的准备，防止工作过程中的数据丢失
 * @author Administrator
 * 
 */
public class JavaVMStackOOM {
	
	private void dontStop(){
		while(true){
			System.out.println("..");
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread =new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
			
		}
	
	}
	 
	public static void main(String[] args) {
		 JavaVMStackOOM oom=new JavaVMStackOOM();
		 oom.stackLeakByThread();
		
	}

}
