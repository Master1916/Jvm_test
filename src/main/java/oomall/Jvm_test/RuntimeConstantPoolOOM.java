package oomall.Jvm_test;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池的溢出
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * JDK 6 会报Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 * JDK 7 会一直运行下去
 * 
 * @author Administrator
 * 
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		System.out.println("--");
		// 使用list保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10M的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while (true) {System.out.println("--");
			list.add(String.valueOf(i++).intern());
		}

	}

}
