package com.ryanstillwagon.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.File;
import java.util.ArrayList;

public class MapTool extends ApplicationAdapter {
	private SpriteBatch batch;
	private Resources res;
	private Stage stage;
	private Button button;
	private Skin buttonSkin;
	private ArrayList<ClickableTile> tileList;

	private int winHeight;
	private int winWidth;
	 private int mapID = 0;

	private void loadGrid(){
	    for(int y = res.TILE_SIZE; y < winHeight - res.TILE_SIZE; y += res.TILE_SIZE){
	        for (int x = res.TILE_SIZE; x < winWidth - res.TILE_SIZE; x+= res.TILE_SIZE){
	            ClickableTile temp = new ClickableTile(res);
	            temp.sprite.setPosition(x, y);
	            tileList.add(temp);
	            temp.setBounds(temp.sprite.getX(), temp.sprite.getY(), temp.sprite.getWidth(), temp.sprite.getHeight());
	            temp.setTouchable(Touchable.enabled);
	            stage.addActor(temp);
            }
        }
    }
    @Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		mapID = new File("C:\\Users\\still\\IdeaProjects\\first-tutorial\\android\\assets\\maps").listFiles().length + 1;

		batch = new SpriteBatch();
		res = new Resources();
		button = new TextButton("Export", buttonSkin, "small");
		button.setSize(res.TILE_SIZE * 2, res.TILE_SIZE);
		button.setPosition(0,0);
		button.setTransform(true);
		button.scaleBy(0.025f);
		button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				FileHandle exportFile = Gdx.files.absolute("C:\\Users\\still\\IdeaProjects\\first-tutorial\\android\\assets\\maps\\level"+mapID+".txt");
				for(int i = 0; i < tileList.size(); i++ ) {
					exportFile.writeString(Integer.toString(tileList.get(i).getValue()), true);
				}
			}
		});
		tileList = new ArrayList<ClickableTile>();

		winWidth = Gdx.graphics.getWidth();
		winHeight = Gdx.graphics.getHeight();

		loadGrid();
		stage.addActor(button);
	}
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	@Override
	public void dispose () {
		batch.dispose();
		res.dispose();
	}
}
