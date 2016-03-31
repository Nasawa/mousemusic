package MouseMusic;

public class Note
{
	int defaultNote = 60, defaultVolume = 80, defaultTime = 800;

	public Note(int n, int v, int t)
	{
		defaultNote = n;
		defaultVolume = v;
		defaultTime = t;
	}
	
	public Note(int n, int t)
	{
		defaultNote = n;
		defaultTime = t;
	}
	
	public Note(int n)
	{
		defaultNote = n;
	}
	
	public int getNote()
	{
		return defaultNote;
	}

	public void setNote(int defaultNote)
	{
		this.defaultNote = defaultNote;
	}

	public int getVolume()
	{
		return defaultVolume;
	}

	public void setVolume(int defaultVolume)
	{
		this.defaultVolume = defaultVolume;
	}

	public int getTime()
	{
		return defaultTime;
	}

	public void setTime(int defaultTime)
	{
		this.defaultTime = defaultTime;
	}
}
