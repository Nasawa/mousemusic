package MouseMusic;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class SuperSynth
{
	int defaultNote = 60, defaultVolume = 64, defaultTime = 100, channel = 0;
	private Synthesizer synth;
	private MidiChannel[] channels;
	
	public SuperSynth(int n, int v, int t)
	{
		defaultNote = n;
		defaultVolume = v;
		defaultTime = t;
		initialize();
	}
	
	public SuperSynth() 
	{
		initialize();
	}
	
	private void initialize()
	{
		try
		{
			synth = MidiSystem.getSynthesizer();
	        synth.open();
	        channels = synth.getChannels();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong!");
			e.printStackTrace();
			destroy();
		}
	}
	
	public void destroy()
	{
		System.out.println("Closing synth");
		synth.close();
	}
	
	/*public void play() throws InterruptedException
	{
		channels[channel].noteOn( defaultNote, defaultVolume );
		Thread.sleep(defaultTime);
		channels[channel].noteOff( defaultNote );
	}
	
	public void play(int note) throws InterruptedException
	{
		channels[channel].noteOn( note, defaultVolume );
		Thread.sleep(defaultTime);
		channels[channel].noteOff( note );
	}
	
	public void play(int note, int volume) throws InterruptedException
	{
		channels[channel].noteOn( note, volume );
		Thread.sleep(defaultTime);
		channels[channel].noteOff( note );
	}
	
	public void play(int note, int volume, int time) throws InterruptedException
	{
		channels[channel].noteOn( note, volume );
		Thread.sleep(time);
		channels[channel].noteOff( note );
	}*/
	
	public void play(Note note) throws InterruptedException
	{
		if(note.getNote() < 0)
		{
			Thread.sleep(note.getTime());
			return;
		}
		channels[channel].noteOn( note.getNote(), note.getVolume() );
		Thread.sleep(note.getTime());
		channels[channel].noteOff( note.getNote() );
	}
	
	public int getDefaultNote()
	{
		return defaultNote;
	}
	
	public int getDefaultVolume()
	{
		return defaultVolume;
	}
	
	public int getDefaultTime()
	{
		return defaultTime;
	}
	
	public void setDefaultNote(int note)
	{
		defaultNote = note;
	}
	
	public void setDefaultVolume(int volume)
	{
		defaultVolume = volume;
	}
	
	public void setDefaultTime(int time)
	{
		defaultTime = time;
	}
	
	public int getChannel()
	{
		return channel;
	}

	public void setChannel(int channel)
	{
		this.channel = channel;
	}

	public void setProgram(int program)
	{
		channels[channel].programChange(channel, program);
	}
	
	public void setProgram(int chan, int program)
	{
		channels[channel].programChange(chan, program);
	}
	
}