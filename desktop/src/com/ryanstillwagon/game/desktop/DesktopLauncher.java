package com.ryanstillwagon.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ryanstillwagon.game.MapTool;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 480;
		config.width = 640;
		config.foregroundFPS = 60;
		new LwjglApplication(new MapTool(), config);
	}
}
