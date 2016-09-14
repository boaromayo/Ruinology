import java.awt.image.*;

public final class Constants {
	// PANEL CONSTANTS.
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	public static final int FPS = 60;
	
	// PLAYER CONSTANTS.
	public static final int PLAYER_SIZE = 24;
	public static final int DELAY_COUNT = 8;
	
	// FILE PATHS.
	
	// TITLE IMAGE.
	public static final String _titlePath = "../img/title.png";
	
	// PAUSE IMAGE.
	public static final String _pauseTitlePath = "../img/pausetitle.png";
	
	// CURSOR.
	public static final String _cursorPath = "../img/cursor.png";
	
	// PLAYER FILE.
	public static final String _playerPath = "../img/player.png";
	
	// TIMER.
	public static final String _timerPath = "../img/timer.png";
	
	// HEALTH.
	public static final String _heartPath = "../img/heart.gif";
	
	// STAMINA.
	public static final String _staminaPath = "../img/stamina.gif";
	
	// ITEMS.
	public static final String _hrglassPath = "../img/hourglass.png";
	
	// ITEMS -> USABLE ITEMS.
	public static final String _bluePotionPath = "../img/potion_blue.gif";
	public static final String _greenPotionPath = "../img/potion_green.gif";
	
	// ITEMS -> MONEY.
	public static final String _bronzeCoinPath = "../img/coin_bronze.gif";
	public static final String _silverCoinPath = "../img/coin_silver.gif";
	public static final String _goldCoinPath = "../img/coin_gold.gif";
	
	// IMAGES.
	
	// TITLE IMAGE.
	public static final BufferedImage _title = ImageBank.loadImage(_titlePath);
	
	// PAUSE IMAGE.
	public static final BufferedImage _pauseTitle = ImageBank.loadImage(_pauseTitlePath);
	
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
}
