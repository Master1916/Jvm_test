package oomall.Jvm_test;

import java.util.ArrayList;
import java.util.List;


/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * -XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时Dump出当前
 * 的内存堆转储快照
 * @author Administrator
 *
 */
public class HeapOOM {
	
	static class OOMObject{
	}
	
	public static void main(String[] args){
			List<OOMObject> list=new ArrayList<OOMObject>();
			while(true){
				list.add(new OOMObject());
			}
	}

}
