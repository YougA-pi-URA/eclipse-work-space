package iteratorpattern;

public class MyTeacher extends Teacher {

	private MyStudentList list;

	@Override
	public void createStudentList() {

		studentList = new StudentList(5);

		studentList.add(new Student("赤井亮太",1));
		studentList.add(new Student("赤羽里美",0));
		studentList.add(new Student("岡田美央",0));
		studentList.add(new Student("西森俊介",1));
		studentList.add(new Student("中ノ森玲菜",0));

	}

	@Override
	public void callStudents() {

		Iterator ite = list.iterator();
		while(ite.hasnext()){
			System.out.println(((Student)ite.next()).getName());
		}

	}

}
