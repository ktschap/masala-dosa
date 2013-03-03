package pepparkmead.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pepparkmead.data.Registration;
import pepparkmead.data.Registration.RegComparator;

public class RegistrationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetStudentTeacherRoom() {
		Registration r = new Registration();
		r.setStudentTeacher("Ball");
		assertEquals("21", r.getStudentTeacherRoom());
		r.setStudentTeacher("Malton");
		assertEquals("18", r.getStudentTeacherRoom());
	}
	
	@Test
	public void testRegComparator() {
		RegComparator comp = new RegComparator();
		Registration a = createReg("a");
		Registration a2 = createReg("a");
		Registration b = createReg("b");
		Registration bCap = createReg("B");
		Registration c = createReg("c");
		assertEquals(0, comp.compare(a2,  a));
		assertTrue(comp.compare(a, b) < 0);
		assertTrue(comp.compare(b, c) < 0);
		assertTrue(comp.compare(a, c) < 0);
		assertTrue(comp.compare(c, a) > 0);
		assertTrue(comp.compare(b, bCap) == 0);
	}

	private Registration createReg(String l) {
		Registration r = new Registration();
		r.setStudentNameLast(l);
		return r;
	}

}
