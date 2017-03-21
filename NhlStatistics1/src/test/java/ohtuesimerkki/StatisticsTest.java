/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juuso_j0pbwen
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void searchPlayerReturnsCorrectPlayer() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri", player.getName());
    }
    
    @Test
    public void searchPlayerReturnsNullCorrectly() {
        Player player = stats.search("Selanne");
        assertEquals(null, player);
    }
    
    @Test
    public void teamReturnsCorrectPlayers() {
        List<Player> players = stats.team("EDM");
        String[] names = {"Semenko", "Kurri", "Gretzky"};
        for (int i = 0; i < players.size(); i++) {
            assertEquals(names[i], players.get(i).getName());
        }
    }
    
    @Test
    public void teamReturnsEmptyListCorrectly() {
        List<Player> players = stats.team("TEST");
        assertEquals(0, players.size());
    }
    
    @Test
    public void TopscorersReturnsCorrectAmountOfPlayers() {
        List<Player> players = stats.topScorers(2);
        assertEquals(2, players.size());
    }
    
    @Test
    public void TopscorersReturnsCorrectPlayers() {
        List<Player> players = stats.topScorers(2);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
    }
    
    @Test
    public void TopscorersReturnsEmptyListOfPlayersCorrectly() {
        List<Player> players = stats.topScorers(0);
        assertEquals(0, players.size());
    }
    
    @Test
    public void TopscorersWorksCorrectlyWithNegativeNumbers() {
        List<Player> players = stats.topScorers(-2);
        assertEquals(0, players.size());
    }
    
}
