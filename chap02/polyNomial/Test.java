package polyNomial;

public class Test {
	
	public static void main(String[] args) {
		
		Term[] terms1 = new Term[5];
		for(int i=0; i<5; i++){
			terms1[i] = new Term(i+1, 3-i);
		}
		
		Term[] terms2 = new Term[5];
		for(int i=0; i<5; i++){
			terms2[i] = new Term(i-3, 3-i);
		}

		PolySinglyList<Term> psl1 = new PolySinglyList<>(terms1);
		PolySinglyList<Term> psl2 = new PolySinglyList<>(terms2);
		System.out.println(psl1.toString());
		System.out.println(psl2.toString());
		
		PolySinglyList<Term> psl = psl1.add(psl2);
		psl.simplify();
		System.out.println(psl.toString());
	}
}
