package businessLogic;

import java.awt.Color;
/**
 * The HSL space is used to represent color in a way that is closer to how human vision works. 
 * It is based in cilyndric coordinates. It is used in this project to manage the dynamics 
 * between articles of clothing.
 * @author jucat
 *
 */
public class HSL{
	/**Uses <code>Math.random</code> to generate a random RGB color
	 * @return an object Color in an RGB space
	 * 
	 * @see Color
	 */
	public static Color randomColor() {
		int[] rgb = new int[3];
		for(int i=0;i<rgb.length;i++) {
			rgb[i]=(int) (Math.random() * 255);
		}
		return new Color(rgb[0],rgb[1],rgb[2]);
	}
	
	/**
	 * Convert an RGB color onto its corresponding HSL values.
	 * <p>This function was originally written by Rob Cammick, 
	 * and was published in his blog: {@link https://tips4java.wordpress.com/2009/07/05/hsl-color/}
	 * @param color an object Color in the RGB space
	 * @return an array containing 3 HSL values
	 */
	

	public static double[] fromRGB(Color color)
	{
		//  Get RGB values in the range 0 - 1

		float[] rgb = color.getRGBColorComponents( null );
		double r = rgb[0];
		double g = rgb[1];
		double b = rgb[2];

		//	Minimum and Maximum RGB values are used in the HSL calculations

		double min = Math.min(r, Math.min(g, b));
		double max = Math.max(r, Math.max(g, b));

		//  Calculate the Hue

		double h = 0;

		if (max == min)
			h = 0;
		else if (max == r)
			h = ((60 * (g - b) / (max - min)) + 360) % 360;
		else if (max == g)
			h = (60 * (b - r) / (max - min)) + 120;
		else if (max == b)
			h = (60 * (r - g) / (max - min)) + 240;

		//  Calculate the Luminance

		double l = (max + min) / 2;

		//  Calculate the Saturation

		double s = 0;

		if (max == min)
			s = 0;
		else if (l <= .5f)
			s = (max - min) / (max + min);
		else
			s = (max - min) / (2 - max - min);

		return new double[] {h, s * 100, l * 100};
	}
}