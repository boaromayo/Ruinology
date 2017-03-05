package content;
// Special thanks to foreignguymike for the tutorial on how to play sounds and music!

import javax.sound.sampled.*;

public final class AudioBank {
	// Prevents any client code instantiation.
	private AudioBank() {}
	
	// SINGLETON OBJECT.
	private static AudioBank _ab = null;
	
	// Call instance to ensure only one object is used throughout program.
	public static AudioBank get() {
		synchronized (AudioBank.class) {
			if (_ab == null)
				_ab = new AudioBank();
		}
		
		return _ab;
	}
	
	
	public Clip load(String path) {
		Clip clip = null;
		try {
			System.out.println("Loading " + path + "...");
			AudioInputStream codeais = AudioSystem.getAudioInputStream(AudioSystem.class.getResourceAsStream(path));
			AudioFormat base = codeais.getFormat();
			System.out.println("Decoding " + path + "...");
			AudioFormat decoder = decodeClip(base);
			AudioInputStream decodeais = AudioSystem.getAudioInputStream(decoder, codeais);
			clip = AudioSystem.getClip();
			clip.open(decodeais);
			return clip;
		} catch (Exception e) {
			System.err.println("ERROR: Unable to load audio clip.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return clip;
	}
	
	public void play(Clip clip) {
		if (clip == null)
			return;
		
		stop(clip);
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void stop(Clip clip) {
		if (clip.isRunning())
			clip.stop();
	}
	
	public void close(Clip clip) {
		stop(clip);
		if (clip.isOpen())
			clip.close();
	}
	
	private AudioFormat decodeClip(AudioFormat base) {
		try {
			AudioFormat decoder = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
					base.getSampleRate(), 
					16, 
					base.getChannels(), 
					base.getChannels() * 2, 
					base.getSampleRate(), 
					false);
			return decoder;
		} catch (Exception e) {
			System.err.println("ERROR: Unable to decode audio.");
			System.err.println("REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
