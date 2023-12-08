package java8;

import com.model.Tile;
import com.utility.TileUtility;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Java8FeaturesTest {

    static List<Tile> tileList;

    @BeforeClass
    public static void setup(){
        tileList = TileUtility.getTilesList();
    }

    @Test
    public void filterRedTilesTest(){
        List<Tile> redTilesList = TileUtility.filterTiles(tileList, (Tile tile) -> "red".equals(tile.getColor()));
        assertEquals(3, redTilesList.size());
    }

    @Test
    public void filterCostlyTiles(){
        List<Tile> costlyTiles = TileUtility.filterTiles(tileList, tile -> tile.getCost() > 1000);
        System.out.println(costlyTiles);
    }

    @Test
    public void prettyPrintFirstTest(){
        TileUtility.prettyPrintTiles(tileList, tile ->{
            if(tile.getCompany().equals("Kajaria")){
                System.out.println("This is the premium tiles of kajaria with cost " + tile.getCost());
            }
        });
    }
}
