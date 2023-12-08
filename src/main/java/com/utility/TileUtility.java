package com.utility;

import com.model.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TileUtility {

    public static List<Tile> getTilesList(){
        return Arrays.asList(
                new Tile("Kajaria", "red", 450),
                new Tile("Kajaria", "green", 1050),
                new Tile("Kajaria", "blue", 700),
                new Tile("Johnson", "red", 320),
                new Tile("Johnson", "white", 300),
                new Tile("Johnson", "green", 800),
                new Tile("Jaquar", "black", 650),
                new Tile("Jaquar", "blue", 1200),
                new Tile("Jaquar", "red", 540),
                new Tile("Jaquar", "white", 1550)
        );
    }

    public static List<Tile> filterTiles(List<Tile> tilesList, Predicate<Tile> predicate){
        List<Tile> result = new ArrayList<>();

        for(Tile tile : tilesList){
            if(predicate.test(tile)){
                result.add(tile);
            }
        }

        return result;
    }

    public static void prettyPrintTiles(List<Tile> tileList, Consumer<Tile> consumer){
        for(Tile tile : tileList){
            consumer.accept(tile);
        }
    }
}
