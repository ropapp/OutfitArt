package businessLogic;

import java.util.HashMap;

public class Clothes extends Node{
	HashMap<String, float[]> hmap = new HashMap<String, float[]>();
	HashMap<Integer, String> types = new HashMap<Integer, String>();
	public Clothes() {
		hmap.put("formal", new float[] {1f,0f});
		hmap.put("cold", new float[] {0f,-1f});
		hmap.put("rainy", new float[] {0f,-0.75f});
		hmap.put("sport", new float[] {-1,0});
		hmap.put("sunny", new float[] {0,0.75f});
		hmap.put("hot", new float[] {0,1});
		
		types.put(1, "Jacket/Sweater");
		types.put(2, "Shirt/Blouse");
		types.put(3, "Pants");
		types.put(4, "Footwear");
	}
	
	
	
}
