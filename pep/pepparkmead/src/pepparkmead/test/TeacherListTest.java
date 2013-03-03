package pepparkmead.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pepparkmead.TeacherList;

public class TeacherListTest {

	@Test
	public void testListOk() {
		assertNotNull(TeacherList.TEACHER_LIST);
		assertTrue(TeacherList.TEACHER_LIST.size() > 10);
		for (String t : TeacherList.TEACHER_LIST) {
			assertTrue("Error with: " + t, t.length() >= 4);
		}
	}
	
	@Test
	public void testRoomLookup() {
		String room = TeacherList.getRoom("Ball");
		assertEquals("21", room);
		room = TeacherList.getRoom("SomeNonExistantTeacher");
		assertNull(room);
	}

}
