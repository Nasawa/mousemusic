package MouseMusic;

import java.util.HashMap;
import java.util.Vector;

public class SuperMusic
{
	static Vector<Note> noteVector;
	static HashMap<String, Integer> alias;
	
	static int[] p = new int[2], o = new int[3];
	static int unit = 400, e = unit*1, q = unit*2, qp = unit*3, h = unit*4, eh = unit*5, 
			hp = unit*6, w = unit*8, wp = unit*12, qw = unit*10;
	
	public SuperMusic() 
	{
		addAlias();
	}
	
	public static void addAlias()
	{
		alias = new HashMap<String, Integer>();
		alias.put("c5", 72);
		alias.put("b4", 71);
		alias.put("a4", 69);
		alias.put("g4", 67);
		alias.put("f4", 65);
		alias.put("e4", 64);
		alias.put("d4", 62);
		alias.put("c4", 60);
		alias.put("b3", 59);
		alias.put("a3", 57);
		alias.put("g3", 55);
		alias.put("f3", 53);
		alias.put("e3", 52);
		alias.put("d3", 50);
		alias.put("c3", 48);
		alias.put("b2", 47);
		alias.put("a2", 45);
		
		alias.put("xx", -1);
	}
	
	public static void na(String key)//"notes adder"
	{
		noteVector.addElement(new Note(alias.get(key)));
	}
	
	public static void na(String key, int t)
	{
		noteVector.addElement(new Note(alias.get(key), t));
	}
	
	public static void na(String key, boolean isFlat)
	{
		noteVector.addElement(new Note(alias.get(key) - (isFlat ? 1 : -1)));
	}
	
	public static void na(String key, int t, boolean isFlat)
	{
		noteVector.addElement(new Note(alias.get(key) - (isFlat ? 1 : -1), t));
	}
}
