package genlist;

public class Test {
	public static void main(String[] args) {
		//构造原子数组,并初始化
//		Integer[] atoms = new Integer[10];
//		for(int index = 0; index<atoms.length; index++)
//			atoms[index] = index;
//		
//		//构造广义表对象
//		GenList<Integer> gl = new GenList<>(atoms);
//		
//		System.out.println("初始输出："+gl.toString());
//		
//		//追加一个节点
//		gl.append(atoms.length);
//		System.out.println("追加后输出:"+gl.toString());
//		
//		//插入节点
//		gl.insert(3, 12);
//		gl.insert(13, 13);
//		System.out.println("插入节点后:"+gl.toString());
		
		//插入索引出错
//		gl.insert(-1, -1);
		
		GenList<Integer> gl2 = new GenList<>();
		gl2.append(0);
		gl2.append(1);
		System.out.println(gl2.toString());
		
		GenList<Integer> gl3 = new GenList<>();
		gl3.append(3);
		gl3.append(4);
		System.out.println(gl3.toString());
		
		gl2.insert(1, gl3);
		System.out.println(gl2.toString());
		
		GenNode<Integer> curr = gl2.head;
		System.out.println(curr.next.data);
		System.out.println(curr.next.child);
		System.out.println(curr.next.next);
	}
}
