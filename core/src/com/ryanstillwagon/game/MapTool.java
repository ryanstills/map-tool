package com.ryanstillwagon.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;

public class MapTool extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	TiledMapRenderer levelRenderer;
	Resources res;
	ArrayList<ClickableTile> tileList;
	int winHeight;
	int winWidth;
	int clickX;
	int clickY;

	private void loadGrid(){
	    for(int y = res.TILE_SIZE; y < winHeight - res.TILE_SIZE; y += res.TILE_SIZE){
	        for (int x = res.TILE_SIZE; x < winWidth - res.TILE_SIZE; x+= res.TILE_SIZE){
	            ClickableTile temp = new ClickableTile(res);
	            temp.sprite.setPosition(x, y);
	            tileList.add(temp);
            }
        }
    }
    private void renderGrid(){
	    for(ClickableTile tile: tileList){
	        batch.draw(tile.sprite, tile.sprite.getX(), tile.sprite.getY());
	    }
    }
    private void checkForMouseClick(){
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){

        }
    }
    @Override
	public void create () {
		batch = new SpriteBatch();
		res = new Resources();
		levelRenderer = new OrthogonalTiledMapRenderer(res.background);
		tileList = new ArrayList<ClickableTile>();

		winWidth = Gdx.graphics.getWidth();
		winHeight = Gdx.graphics.getHeight();

		loadGrid();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, winWidth, winHeight);
		camera.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        levelRenderer.setView(camera);
        levelRenderer.render();
		batch.begin();
            renderGrid();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		res.dispose();
	}
}
