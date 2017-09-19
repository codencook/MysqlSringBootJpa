package com.source;

import com.source.domain.Game;
import com.source.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpamysqlApplication.class)
@WebAppConfiguration


public class JpamysqlApplicationTests {

	@Autowired
	GameRepository gameRepository;

	@Before
	public void setUp() throws Exception {
		gameRepository.deleteAll();
		Game pandemic = new Game("Pandemic", "Co-op game for wannabe disease control specailists");
		Game werewolf = new Game("Wolf2", "You must find out who's secretly the werewolf, before it's too late");
		Game camelUp = new Game("Camel Up", "A high stakes game of gambling and camel racing");
		gameRepository.save(pandemic);
		gameRepository.save(werewolf);
		gameRepository.save(camelUp);
	}

	@Test
	public void testLoadGames() {
		List<Game> games = (ArrayList<Game>) gameRepository.findAll();
		assertEquals("Did not get all games", 3, games.size());
	}

	@Test
	public void testFindGame() throws Exception {
		List<Game> camelUpList = gameRepository.findByName("Camel Up");
		assertEquals("Found wrong number of Camel Ups", 1, camelUpList.size());
		assertEquals("Found wrong name", "Camel Up", camelUpList.get(0).getName());
	}

}
