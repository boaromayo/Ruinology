package content;
import java.awt.image.*;

import javax.sound.sampled.*;

public final class Constants {
	// PANEL CONSTANTS.
	public static final int WIDTH = 480;
	public static final int HEIGHT = 360;
	public static final int HEIGHT_HUD = 40;
	public static final int HEIGHT_FINAL = HEIGHT + HEIGHT_HUD;
	public static final int FPS = 60;
	
	// PLAYER CONSTANTS.
	public static final int PLAYER_SIZE = 24;
	public static final int DELAY_COUNT = 8;
	
	// TILE SIZE.
	public static final int TILE_SIZE = 24;
	
	// FONT SIZE.
	private static final int FONT_SIZE = 16;
	
	// FILE PATHS.
	
	// TITLE IMAGE.
	private static final String _titlePath = "../assets/img/title.png";
	
	// PAUSE IMAGE.
	private static final String _pauseTitlePath = "../assets/img/pausetitle.png";
	
	// VICTORY TITLE IMAGE.
	private static final String _victoryPath = "../assets/img/victory_title.png";
	
	// GAMEOVER IMAGE.
	private static final String _gameoverPath = "../assets/img/gameover_title.png";
	
	// TEXT.
	private static final String _fontPath = "../assets/img/font.gif";
	
	// CURSOR.
	private static final String _cursorPath = "../assets/img/cursor.png";
	
	// PLAYER FILE.
	private static final String _playerPath = "../assets/img/player.png";
	
	// TIMER.
	private static final String _timerPath = "../assets/img/timer.png";
	
	// HEALTH.
	private static final String _heartPath = "../assets/img/heart.gif";
	
	// HEALTH COUNTER.
	private static final String _heartCtrGrayPath = "../assets/img/heart_bar_gray.gif";
	private static final String _heartCtrPath = "../assets/img/heart_bar.gif";
	
	// STAMINA.
	private static final String _staminaPath = "../assets/img/stamina.gif";
	
	// STAMINA BAR?
	private static final String _staminaGaugePath = "../assets/img/stamina_gauge.gif";
	
	// ITEMS.
	private static final String _hrglassPath = "../assets/img/hourglass.png";
	
	// ITEMS -> USABLE ITEMS.
	private static final String _bluePotionPath = "../assets/img/potion_blue.gif";
	private static final String _greenPotionPath = "../assets/img/potion_green.gif";
	
	// ITEMS -> MONEY.
	private static final String _bronzeCoinPath = "../assets/img/coin_bronze.gif";
	private static final String _silverCoinPath = "../assets/img/coin_silver.gif";
	private static final String _goldCoinPath = "../assets/img/coin_gold.gif";
	private static final String _crystalPath = "../assets/img/crystal.gif";
	
	// TILESET.
	private static final String _tilesetPath = "../assets/maps/tileset.txt";
	
	// SOUNDS.
	
	// PLAYER SOUNDS.
	private static final String _drinkPath = "../sfx/bubble.wav";
	private static final String _harmPath = "../sfx/harm.wav";
	
	// ITEM GET SOUNDS.
	private static final String _getMoneyPath = "../sfx/clink.wav";
	private static final String _getItemPath = "../sfx/item.wav";
	private static final String _getHrglassPath = "../sfx/warp.wav";
	
	// MENU SOUNDS.
	private static final String _cursorAudioPath = "../sfx/cursor.wav";
	private static final String _selectPath = "../sfx/select.wav";
	private static final String _cancelPath = "../sfx/cancel.wav";
	private static final String _buzzerPath = "../sfx/buzzer.wav";
	
	// IMAGES.
	public static BufferedImage getImage(String path) { return ImageBank.loadImage(path); }
	
	public static BufferedImage[][] getImages(String path, int x, int y, int size) { return ImageBank.loadImages(path, x, y, size); }
	
	// TITLE IMAGE.
	/*public static BufferedImage getTitle() { return getImage(_titlePath); }
	
	// PAUSE IMAGE.
	public static BufferedImage getPauseTitle() { return getImage(_pauseTitlePath); }
	
	// VICTORY TITLE IMAGE.
	public static BufferedImage getVictoryTitle() { return getImage(_victoryPath); }
	
	// GAMEOVER IMAGE.
	public static BufferedImage getGameoverTitle() { return getImage(_gameoverPath); }
	
	// TEXT
	public static BufferedImage[][] getGameFont() { return getImages(_fontPath, 0, 0, FONT_SIZE); }
	
	// CURSOR.
	public static BufferedImage getCursorImg() { return getImage(_cursorPath); }
	
	// PLAYER IMAGES.
	public static BufferedImage[][] getPlayerImages() { return getImages(_playerPath, 0, 0, PLAYER_SIZE); }
	
	// TIMER.
	public static BufferedImage getTimerImg() { return getImage(_timerPath); }
	
	// HEALTH.
	public static BufferedImage getHeartImg() { return getImage(_heartPath); }
	public static BufferedImage getHealthCtrImg(boolean healthy) {
		if (healthy)
			getImage(_heartCtrPath);
		else
			getImage(_heartCtrGrayPath);
	}
	
	// STAMINA.
	//public static BufferedImage _stamina = ImageBank.loadImage(_staminaPath);
	
	// ITEMS.
	public static BufferedImage getHrglassImg() { return getImage(_hrglassPath); }
	
	// ITEMS -> USABLE ITEMS.
	public static BufferedImage getBluePotionImg() { return getImage(_bluePotionPath); }
	public static BufferedImage getGreenPotionImg() { return getImage(_greenPotionPath); }
	
	// ITEMS -> MONEY.
	public static BufferedImage getBronzeCoinImg() { return getImage(_bronzeCoinPath); }
	public static BufferedImage getSilverCoinImg() { return getImage(_silverCoinPath); }
	public static BufferedImage getGoldCoinImg() { return getImage(_goldCoinPath); }
	public static BufferedImage getCrystalImg() { return getImage(_crystalPath); }*/
	
	// TILESET.
	public static String getTilesetPath() { return _tilesetPath; }
	
	// SOUNDS.
	public static Clip getClip(String path) { return AudioBank.load(path); } 
	
	// PLAYER SOUNDS.
	/*public static Clip drink() { return getClip(_drinkPath); }
	public static Clip harm() { return getClip(_harmPath); }
	
	// ITEM GET SOUNDS.
	public static Clip getMoney() { return getClip(_getMoneyPath); }
	public static Clip getItem() { return getClip(_getItemPath); }
	public static Clip getHrglass() { return getClip(_getHrglassPath); }
	
	// MENU SOUNDS.
	public static Clip cursor() { return getClip(_cursorAudioPath); }
	public static Clip select() { return getClip(_selectPath); }
	public static Clip cancel() { return getClip(_cancelPath); }
	public static Clip buzzer() { return getClip(_buzzerPath); }*/
}
