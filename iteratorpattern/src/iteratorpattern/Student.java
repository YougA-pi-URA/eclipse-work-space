package iteratorpattern;

public class Student {

	private String name;
	private int sex;

	public Student(String name, int sex){
		this.name = name;
		this.sex = sex;
	}

	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}

	/**
	 * sexを取得します。
	 * @return sex
	 */
	public int getSex() {
	    return sex;
	}

}
