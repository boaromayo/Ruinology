package content;
import java.awt.*;
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
	private static final int FONT_SIZE = 20;
	
	// FILE PATHS.
	private static final String _imgPath = "/assets/img/";
	private static final String _mapPath = "/assets/maps/";
	private static final String _sfxPath = "/assets/sfx/";
	
	// ICON IMAGE /* ICON SIZE: 16 */
	private static final String _iconPath = _imgPath + "icon.png";
	
	// TITLE IMAGE /* TITLE WIDTH: 416, TITLE HEIGHT: 64 */.
	private static final String _titlePath = _imgPath + "title.png";
	
	// PAUSE IMAGE.
	private static final String _pauseTitlePath = _imgPath + "pausetitle.png";
	
	// VICTORY TITLE IMAGE.
	private static final String _victoryPath = _imgPath + "victory_title.png";
	
	// GAMEOVER IMAGE.
	private static final String _gameoverPath = _imgPath + "gameover_title.png";
	
	// TEXT.
	private static final String _fontPath = _imgPath + "font.gif";
	
	// TEXT SMALL.
	private static final String _fontSmallPath = _imgPath + "font-small.png";
	
	// CURSOR.
	private static final String _cursorPath = _imgPath + "cursor.png";
	
	// PLAYER FILE.
	private static final String _player1Path = _imgPath + "player-1.png";
	private static final String _player2Path = _imgPath + "player-2.png";
	private static final String _player3Path = _imgPath + "player-3.png";
	
	// TIMER.
	private static final String _timerPath = _imgPath + "timer.png";
	
	// HEALTH.
	private static final String _heartPath = _imgPath + "heart.gif";
	
	// HEALTH COUNTER.
	private static final String _heartCtrGrayPath = _imgPath + "heart_bar_gray.gif";
	private static final String _heartCtrPath = _imgPath + "heart_bar.gif";
	
	// STAMINA.
	//private static final String _staminaPath = _imgPath + "stamina.gif";
	
	// STAMINA BAR?
	//private static final String _staminaGaugePath = _imgPath + "stamina_gauge.gif";
	
	// ITEMS.
	private static final String _hrglassPath = _imgPath + "hourglass.png";
	
	// ITEMS -> USABLE ITEMS.
	private static final String _bluePotionPath = _imgPath + "potion_blue.gif";
	private static final String _greenPotionPath = _imgPath + "potion_green.gif";
	
	// ITEMS -> MONEY.
	private static final String _bronzeCoinPath = _imgPath + "coin_bronze.gif";
	private static final String _silverCoinPath = _imgPath + "coin_silver.gif";
	private static final String _goldCoinPath = _imgPath + "coin_gold.gif";
	private static final String _crystalPath = _imgPath + "crystal.gif";
	
	// TILESET.
	private static final String _tilesetImgPath = _imgPath + "ruintile.gif";
	private static final String _tilesetPath = _mapPath + "tileset.txt";
	
	// DEFAULT TILE.
	private static final String _blankTilePath = _imgPath + "blank.gif";
	
	// SOUNDS.
	
	// PLAYER SOUNDS.
	private static final String _drinkPath = _sfxPath + "bubble.wav";
	private static final String _harmPath = _sfxPath + "harm.wav";
	
	// ITEM GET SOUNDS.
	private static final String _getMoneyPath = _sfxPath + "clink.wav";
	private static final String _getItemPath = _sfxPath + "item.wav";
	private static final String _getHrglassPath = _sfxPath + "warp.wav";
	
	// MENU SOUNDS.
	private static final String _cursorAudioPath = _sfxPath + "cursor.wav";
	private static final String _selectPath = _sfxPath + "select.wav";
	private static final String _cancelPath = _sfxPath + "cancel.wav";
	private static final String _buzzerPath = _sfxPath + "buzzer.wav";
	
	// IMAGES.
	public static BufferedImage getImage(String path) { return ImageBank.get().loadImage(path); }
	
	public static BufferedImage[][] getImages(String path, int x, int y, int size) { return ImageBank.get().loadImages(path, x, y, size); }
	
	// ICON IMAGE.
	public static Image getIcon() { return ImageBank.get().loadImageIcon(_iconPath); }
	
	// TITLE IMAGE.
	public static BufferedImage getTitle() { return getImage(_titlePath); }
	
	// PAUSE IMAGE.
	/*public static BufferedImage getPauseTitle() { return getImage(_pauseTitlePath); }
	
	// VICTORY TITLE IMAGE.
	public static BufferedImage getVictoryTitle() { return getImage(_victoryPath); }
	
	// GAMEOVER IMAGE.
	public static BufferedImage getGameoverTitle() { return getImage(_gameoverPath); }*/
	
	// TEXT.
	public static BufferedImage[][] getGameFont() { return getImages(_fontPath, 0, 0, FONT_SIZE); }
	
	// CURSOR.
	/*public static BufferedImage getCursorImg() { return getImage(_cursorPath); }
	
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
	//public static BufferedImage _stamina = ImageBank.loadImage(_staminaPath);*/
	
	// ITEMS.
	public static BufferedImage getHrglassImg() { return getImage(_hrglassPath); }
	
	// ITEMS -> USABLE ITEMS.
	public static BufferedImage getBluePotionImg() { return getImage(_bluePotionPath); }
	public static BufferedImage getGreenPotionImg() { return getImage(_greenPotionPath); }
	
	// ITEMS -> MONEY.
	public static BufferedImage getBronzeCoinImg() { return getImage(_bronzeCoinPath); }
	public static BufferedImage getSilverCoinImg() { return getImage(_silverCoinPath); }
	public static BufferedImage getGoldCoinImg() { return getImage(_goldCoinPath); }
	public static BufferedImage getCrystalImg() { return getImage(_crystalPath); }
	
	// TILESET.
	public static BufferedImage[][] getTileset() { return getImages(_tilesetImgPath, 0, 0, TILE_SIZE); }
	public static int getTilesetWidth() { return getImage(_tilesetImgPath).getWidth(); } // Get the tileset's width, not the tile's width.
	public static String getTilesetPath() { return _tilesetPath; }
	
	// DEFAULT TILE.
	public static BufferedImage getBlankTile() { return getImage(_blankTilePath); }
	
	// ROOM SIZE.
	public static int getRoomWidth() { return Constants.WIDTH / Constants.TILE_SIZE; }
	public static int getRoomHeight() { return Constants.HEIGHT / Constants.TILE_SIZE; }
	
	// SOUNDS.
	public static Clip getClip(String path) { return AudioBank.get().load(path); }
	
	public static void playClip(Clip clip) { AudioBank.get().play(clip); }
	
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
