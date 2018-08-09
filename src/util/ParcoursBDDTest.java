package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Quizz;
import model.User;

class ParcoursBDDTest {

	@Test
	void testNewParcourBDD() {
		
		Quizz quizz=new Quizz(1,null,null);
		User user = new User(1,null,null,null,null,null,null,null,null,false);
		if(ParcoursBDD.newParcourBDD(quizz, user, 5, 1)==null)
		fail("Not yet implemented");
	}

}
