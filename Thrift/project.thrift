# project.thrift

namespace java webservice

struct Student {
  	1: string firstName,
  	2: string secondName,
  	3: i64 numberCourse,
  	4: i64 numberGroup,
}

service StudentService
{
	void add(1: Student student ),
	void modify(1: Student student ),
	void remove(1: Student student ),
}
