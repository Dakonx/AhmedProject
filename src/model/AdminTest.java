package model;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class AdminTest {

	@Test
	void test() {
		
		
		User user = new User(1,"x@gmail.com",null,null, null,null,null,null,null,false);
		if(Admin.deleteUser(user)) {
		fail("Not yet implemented");}
	}

}
