package com.ryanstillwagon.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Resources {

    final int TILE_SIZE;
    private Texture empty_place;
    private Texture one_icon;
    private Texture two_icon;
    private Texture three_icon;
    private Texture four_icon;
    private Texture five_icon;
    private Texture six_icon;
    private Texture seven_icon;
    private Texture eight_icon;
    private Texture nine_icon;
    private Texture ten_icon;
    private Texture eleven_icon;
    private Texture twelve_icon;
    private Texture thirteen_icon;
    private Texture fourteen_icon;
    private Texture fifteen_icon;
    Texture[] iconList = new  Texture[16];
    private TiledMap background;
    Resources(){
        TILE_SIZE = 32;
        empty_place = new Texture("empty_place.png");
        one_icon = new Texture("one_icon.png");
        two_icon = new Texture("two_icon.png");
        three_icon = new Texture("three_icon.png");
        four_icon = new Texture("four_icon.png");
        five_icon = new Texture("five_icon.png");
        six_icon = new Texture("six_icon.png");
        seven_icon = new Texture("seven_icon.png");
        eight_icon = new Texture("eight_icon.png");
        nine_icon = new Texture("nine_icon.png");
        ten_icon = new Texture("ten_icon.png");
        eleven_icon = new Texture("eleven_icon.png");
        twelve_icon = new Texture("twelve_icon.png");
        thirteen_icon = new Texture("thirteen_icon.png");
        fourteen_icon = new Texture("fourteen_icon.png");
        fifteen_icon = new Texture("fifteen_icon.png");

        iconList[0] = empty_place;
        iconList[1] = one_icon;
        iconList[2] = two_icon;
        iconList[3] = three_icon;
        iconList[4] = four_icon;
        iconList[5] = five_icon;
        iconList[6] = six_icon;
        iconList[7] = seven_icon;
        iconList[8] = eight_icon;
        iconList[9] = nine_icon;
        iconList[10] = ten_icon;
        iconList[11] = eleven_icon;
        iconList[12] = twelve_icon;
        iconList[13] = thirteen_icon;
        iconList[14] = fourteen_icon;
        iconList[15] = fifteen_icon;

        background = new TmxMapLoader().load("sample_background.tmx");
    }

    void dispose(){
        empty_place.dispose();
        one_icon.dispose();
        two_icon.dispose();
        three_icon.dispose();
        four_icon.dispose();
        five_icon.dispose();
        six_icon.dispose();
        seven_icon.dispose();
        eight_icon.dispose();
        nine_icon.dispose();
        ten_icon.dispose();
        eleven_icon.dispose();
        twelve_icon.dispose();
        thirteen_icon.dispose();
        fourteen_icon.dispose();
        fifteen_icon.dispose();
        background.dispose();
    }
}
