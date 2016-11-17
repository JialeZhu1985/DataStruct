package polyNomial;

/**
 * 多项式类的项类，包含成员变量系数coef和指数exp
 * 
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class Term implements Comparable<Term>, Addible<Term> {
	public int coef;
	public int exp;

	// 构造方法
	public Term(int coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	@Override
	public int compareTo(Term o) { // 按指数比较两项大小
		return this.exp - o.exp;
	}

	@Override
	public boolean equals(Object obj) {
		Term tmp = (Term) obj;
		return this.exp == tmp.exp;
	}

	@Override
	public Term add(Term t) {
		int coef = this.coef + t.coef;
		return new Term(coef, this.exp);
	}

	@Override
	public boolean removiable() {
		return this.coef == 0;
	}
	
	@Override
	public String toString() {
		if(this.coef>=0)
			return new String("+"+this.coef+"x^"+this.exp);
		else
			return new String(this.coef+"x^"+this.exp);
	}
}