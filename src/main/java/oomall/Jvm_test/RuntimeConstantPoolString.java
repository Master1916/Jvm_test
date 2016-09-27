package oomall.Jvm_test;

/**
 * 
 * java 6 运行都是false 原因： intern()方法会把首次遇到的字符串实例复制到永久代中
 * 返回也是这个永久代中的这个字符的引用。而StringBuilder创建的字符串实例在java堆上 所以必然不是同一个对象
 * 
 * java 7 运行 true flase 原因：intern() 实现不会在复制实例，只是在常量池中记录首次出现的实例引用
 * 因此intern()返回的引用和StringBuilder创建的那个字符串实例是同一个。对str2因为java 这个字符串
 * 在执行StringBuilder.toString（）之前已经出现过，不符合首次出现的原则
 * 
 * @author Administrator
 * 
 */
public class RuntimeConstantPoolString {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}
