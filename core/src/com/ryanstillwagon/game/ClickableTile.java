package com.ryanstillwagon.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.HashMap;
import java.util.Map;


public class ClickableTile{
    static Map<String, ClickableTile> tileHashMap = new HashMap<String, ClickableTile>();
    Sprite sprite;
    int iconListPosition;
    ClickableTile(Resources res){
        iconListPosition = 0;
        sprite = new Sprite(res.iconList[iconListPosition]);
        tileHashMap.put(stringify(), this);
    }



    String stringify(){
        return Integer.toString((int)sprite.getX(), (int)sprite.getY());
    }
}
