package util;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Quizz;

class QuizzBDDTest {

	@Test
	void testGetQuizzBySujet() {
		
		
		List<Quizz>listq= QuizzBDD.getQuizzBySujet("maths");
		if (listq==null) fail("Not yet implemented");
	}

}
