package pepparkmead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TeacherList {

	public final static List<String> TEACHER_LIST = new ArrayList<String>(22);
	public final static HashMap<String, String> ROOM_LIST = new HashMap<String, String>();
	
	static {
		TEACHER_LIST.add("Boone");
		TEACHER_LIST.add("Coker");
		TEACHER_LIST.add("Duggan");				
		TEACHER_LIST.add("Elliott");
		TEACHER_LIST.add("Ensley");
		TEACHER_LIST.add("Espana");
		TEACHER_LIST.add("Gonsalves");
		TEACHER_LIST.add("Halupka");
		TEACHER_LIST.add("Levinthal");
		TEACHER_LIST.add("Malton");
		TEACHER_LIST.add("McIntosh");
		TEACHER_LIST.add("McIntosh (PALS)");
		TEACHER_LIST.add("McClelland");
		TEACHER_LIST.add("Moore");
		TEACHER_LIST.add("Moore (PALS)");
		TEACHER_LIST.add("Nelson");
		TEACHER_LIST.add("Reese");
		TEACHER_LIST.add("Sauve/Smit");
		TEACHER_LIST.add("Smallman");
		TEACHER_LIST.add("Smith");
		TEACHER_LIST.add("Thomas");
		TEACHER_LIST.add("Weyand");
		TEACHER_LIST.add("Young");
		TEACHER_LIST.add("Zazulak");
		ROOM_LIST.put("Boone", "21");
		ROOM_LIST.put("Coker", "16");
		ROOM_LIST.put("Duggan", "23");				
		ROOM_LIST.put("Elliott", "17");
		ROOM_LIST.put("Ensley", "12");
		ROOM_LIST.put("Espana", "11");
		ROOM_LIST.put("Gonsalves", "3");
		ROOM_LIST.put("Halupka", "24");
		ROOM_LIST.put("Levinthal", "22");
		ROOM_LIST.put("Malton", "18");
		ROOM_LIST.put("McIntosh", "2");
		ROOM_LIST.put("McIntosh (PALS)", "8");
		ROOM_LIST.put("McClelland", "15");
		ROOM_LIST.put("Moore", "14");
		ROOM_LIST.put("Moore (PALS)", "7");
		ROOM_LIST.put("Nelson", "5");
		ROOM_LIST.put("Reese", "23");
		ROOM_LIST.put("Sauve/Smit", "1");
		ROOM_LIST.put("Smallman", "?");
		ROOM_LIST.put("Smith", "10");
		ROOM_LIST.put("Thomas", "4");
		ROOM_LIST.put("Weyand", "13");
		ROOM_LIST.put("Young", "9");
		ROOM_LIST.put("Zazulak", "20");
	}

	public static String getRoom(String t) {
		return ROOM_LIST.get(t);
	}
}
