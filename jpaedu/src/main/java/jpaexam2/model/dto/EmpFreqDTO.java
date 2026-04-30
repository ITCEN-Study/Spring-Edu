package jpaexam2.model.dto;

import jpaexam2.model.entity.Dept;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpFreqDTO {
	private int empno;
	private String ename;
	private java.sql.Date  hiredate;
	private int sal;
	private Dept deptno;

	@Override
	public String toString() {
		return "EmpFreqDTO[" +
				"empno=" + empno +
				", ename=" + ename +
				", hiredate=" + hiredate +
				", sal=" + sal +
				", deptno=" + deptno.getDeptno() +
				']';
	}
}
