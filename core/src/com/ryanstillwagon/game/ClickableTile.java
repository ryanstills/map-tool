package com.ryanstillwagon.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ClickableTile extends Actor{
    Sprite sprite;
    private int iconListPosition;
    ClickableTile(final Resources res){
        iconListPosition = 0;
        sprite = new Sprite(res.iconList[iconListPosition]);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if(event.getButton() == Input.Buttons.LEFT) {
                    if (iconListPosition == res.iconList.length - 1) {
                        iconListPosition = 0;
                        sprite.setTexture(res.iconList[iconListPosition]);
                    } else {
                        iconListPosition++;
                        sprite.setTexture(res.iconList[iconListPosition]);
                    }
                }
            }
        });
    }
    public int getValue(){
        return iconListPosition;
    }
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }
}
