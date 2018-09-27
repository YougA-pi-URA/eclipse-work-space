package iteratorpattern;

public class MyStudentIterator implements Iterator {

	private MyStudentList myStudentList;
	private int index;

	public MyStudentIterator(MyStudentList list){

		this.myStudentList = list;
		this.index = 0;

	}

	@Override
	public boolean hasnext() {
		if(myStudentList.getLastNum() > index)
			return true;
		else
			return false;
	}

	@Override
	public Student next() {
		Student s = myStudentList.getStudentAt(index++);
		return s;
	}

}
