package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChoixBDDTest {

	@Test
	void testGetChoixByIDQuestionAndParcour() {
		
		int idQuestion=1;
		int idParcour=1;
		if (ChoixBDD.getChoixByIDQuestionAndParcour( idQuestion, idParcour)==null)
		//System.out.println(ChoixBDD.getChoixByIDQuestionAndParcour( idQuestion, idParcour));
		fail("echec");
	}

}
