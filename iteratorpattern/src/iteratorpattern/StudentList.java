package iteratorpattern;

public class StudentList {

	protected Student[] students;
	private int last = 0;

	public StudentList(){}

	public StudentList(int studentCount){
		this.students = new Student[studentCount];
	}

	public void add(Student student){
		students[last++] = student;
	}

	/**
	 * studentsを取得します。
	 * @return students
	 */
	public Student getStudentAt(int index) {
	    return students[index];
	}

	public int getLastNum(){
		return last;
	}

}
