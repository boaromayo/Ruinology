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
	
	// FILE PATHS.
	
	// TITLE IMAGE.
	private static final String _titlePath = "../img/title.png";
	
	// PAUSE IMAGE.
	private static final String _pauseTitlePath = "../img/pausetitle.png";
	
	// VICTORY TITLE IMAGE.
	private static final String _victoryPath = "../img/victory_title.png";
	
	// GAMEOVER IMAGE.
	private static final String _gameoverPath = "../img/gameover_title.png";
	
	// TEXT.
	private static final String _fontPath = "../img/font.gif";
	
	// CURSOR.
	private static final String _cursorPath = "../img/cursor.png";
	
	// PLAYER FILE.
	private static final String _playerPath = "../img/player.png";
	
	// TIMER.
	private static final String _timerPath = "../img/timer.png";
	
	// HEALTH.
	private static final String _heartPath = "../img/heart.gif";
	
	// STAMINA.
	private static final String _staminaPath = "../img/stamina.gif";
	
	// ITEMS.
	private static final String _hrglassPath = "../img/hourglass.png";
	
	// ITEMS -> USABLE ITEMS.
	private static final String _bluePotionPath = "../img/potion_blue.gif";
	private static final String _greenPotionPath = "../img/potion_green.gif";
	
	// ITEMS -> MONEY.
	private static final String _bronzeCoinPath = "../img/coin_bronze.gif";
	private static final String _silverCoinPath = "../img/coin_silver.gif";
	private static final String _goldCoinPath = "../img/coin_gold.gif";
	
	// SOUNDS.
	
	// PLAYER SOUNDS.
	private static final String _drinkPath = "../audio/bubble.wav";
	private static final String _harmPath = "../audio/harm.wav";
	
	// ITEM GET SOUNDS.
	private static final String _getMoneyPath = "../audio/clink.wav";
	private static final String _getItemPath = "../audio/item.wav";
	private static final String _getHrglassPath = "../audio/warp.wav";
	
	// MENU SOUNDS.
	private static final String _cursorAudioPath = "../audio/cursor.wav";
	private static final String _selectPath = "../audio/select.wav";
	private static final String _cancelPath = "../audio/cancel.wav";
	
	// IMAGES.
	
	// TITLE IMAGE.
	public static final BufferedImage _title = ImageBank.loadImage(_titlePath);
	
	// PAUSE IMAGE.
	public static final BufferedImage _pauseTitle = ImageBank.loadImage(_pauseTitlePath);
	
	// VICTORY TITLE IMAGE.
	public static final BufferedImage _victoryTitle = ImageBank.loadImage(_victoryPath);
	
	// GAMEOVER IMAGE.
	public static final BufferedImage _gameoverTitle = ImageBank.loadImage(_gameoverPath);
	
	// TEXT
	public static final BufferedImage[][] _font = ImageBank.loadImages(_fontPath, 0, 0, 16, 16);
	
	// CURSOR.
	public static final BufferedImage _cursor = ImageBank.loadImage(_cursorPath);
	
	// PLAYER IMAGES.
	public static final BufferedImage[][] _player = ImageBank.loadImages(_playerPath, 0, 0, PLAYER_SIZE, PLAYER_SIZE);
	
	// TIMER.
	public static final BufferedImage _timer = ImageBank.loadImage(_timerPath);
	
	// HEALTH.
	public static final BufferedImage _heart = ImageBank.loadImage(_heartPath);
	
	// STAMINA.
	public static final BufferedImage _stamina = ImageBank.loadImage(_staminaPath);
	
	// ITEMS.
	public static final BufferedImage _hrglass = ImageBank.loadImage(_hrglassPath);
	
	// ITEMS -> USABLE ITEMS.
	public static final BufferedImage _bluePotion = ImageBank.loadImage(_bluePotionPath);
	public static final BufferedImage _greenPotion = ImageBank.loadImage(_greenPotionPath);
	
	// ITEMS -> MONEY.
	public static final BufferedImage _bronzeCoin = ImageBank.loadImage(_bronzeCoinPath);
	public static final BufferedImage _silverCoin = ImageBank.loadImage(_silverCoinPath);
	public static final BufferedImage _goldCoin = ImageBank.loadImage(_goldCoinPath);
	
	// SOUNDS.
	
	// PLAYER SOUNDS.
	public static final Clip _drink = AudioBank.load(_drinkPath);
	public static final Clip _harm = AudioBank.load(_harmPath);
	
	// ITEM GET SOUNDS.
	public static final Clip _getMoney = AudioBank.load(_getMoneyPath);
	public static final Clip _getItem = AudioBank.load(_getItemPath);
	public static final Clip _getHrglass = AudioBank.load(_getHrglassPath);
	
	// MENU SOUNDS.
	public static final Clip _cursorPick = AudioBank.load(_cursorAudioPath);
	public static final Clip _select = AudioBank.load(_selectPath);
	public static final Clip _cancel = AudioBank.load(_cancelPath);
}
