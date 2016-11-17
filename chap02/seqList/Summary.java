package seqList;

/**
 * 	java的继承原则：当一个父类对象引用子类对象时(例如 List list = new LinkedList())，子类对象即是父类对象，反之则不是。
	java的运行时多态：当父类对象引用子类实例时，运行时确定执行哪些在父类中声明(包括继承得来的)、被子类覆盖的方法，不能执行子类增加的成员方法
 * */
public class Summary extends Parent{
	public static void main(String[] args) {
		Parent p = new Child();
		p.print();
		p.print(2);
//		p.print("str");		报错
	}
}

class GrandParent{
	public void print(int x){
		System.out.println("grandParent"+x);
	}
}

class Parent extends GrandParent{
	public void print(){
		System.out.println("parent");
	}
}

class Child extends Parent{
	public void print(){
		System.out.println("child");
	}
	public void print(int x){
		System.out.println("child:"+x);
	}
	public void print(String str){
		System.out.println(str);
	}
}
