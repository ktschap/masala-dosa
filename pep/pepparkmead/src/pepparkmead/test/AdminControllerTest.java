package pepparkmead.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pepparkmead.controller.AdminController;

public class AdminControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHandleRequest()  throws Exception {
		AdminController c = new AdminController();
        String s = c.getAdminPage(null);		
        assertEquals("Admin", s);
	}

}
