package ev3.exercises.library;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.Font;
import lejos.hardware.lcd.TextLCD;;

public class Lcd
{
    private static Brick		brick = BrickFinder.getLocal();
    private static TextLCD		lcd = brick.getTextLCD(Font.getFont(0, 0, Font.SIZE_MEDIUM));
    //private static GraphicsLCD 	g = brick.getGraphicsLCD();

    public static final int MAXCHARS = lcd.getTextWidth();
    public static final int MAXLINES = lcd.getTextHeight();
    
	// Private constructor means this class cannot be instantiated. All access is static.

	private Lcd()
	{
		
	}

	/**
	 * Returns reference to underlying TextLCD object.
	 * @return Refernce to internal TextLCD object.
	 */
	public static TextLCD getTextLCD()
	{
		return lcd;
	}
	
	/**
	 * Clear the LCD of any text. Does not clear data written with
	 * System.out.println.
	 */
	public static void clear()
	{
		lcd.clear();
		lcd.refresh();
	}
	
	/**
	 * Shift text lines up one line.
	 */
	public static void scroll()
	{
		lcd.scroll();
	}
	
	/**
	 * Clear LCD text line. Does not clear data written with
	 * System.out.println.
	 * @param line Line to clear, 1-based.
	 */
	public static void clear(int line)
	{
		lcd.clear(line - 1);
		lcd.refresh();
	}
	
	/**
	 * Clears specific characters in an LCD text line. Does not clear data written with
	 * System.out.println.
	 * @param line Line to clear, 1-based.
	 * @param col Column to start clearing, 1-based.
	 * @param len Number of columns to clear.
	 */
	public static void clear(int line, int col, int len)
	{
		lcd.clear(col - 1, line - 1, len);
		lcd.refresh();
	}
	
	/**
	 * Print a String to specified text line.
	 * @param line Line to print on, 1-based.
	 * @param message String to print.
	 */
	public static void print(int line, String message)
	{
		lcd.drawString(message, 0, line - 1);
		lcd.refresh();
	}
	
	/**
	 * Print a String to specified text line.
	 * @param line Line to print on, 1-based.
	 * @param message String to print with optional format specifiers for listed parameters.
	 * @param parms Parameter list matching format specifiers.
	 */
	public static void print(int line, String message, Object... parms)
	{
		lcd.drawString(String.format(message, parms), 0, line - 1);
		lcd.refresh();
	}
	
	/**
	 * Print a String to the specified text line starting at the specified column.
	 * @param line Line to print on, 1-based
	 * @param col Column to start printing on, 1-based.
	 * @param message String to print.
	 */
	public static void print(int line, int col, String message)
	{
		lcd.drawString(message, col - 1, line - 1);
		lcd.refresh();
	}
	
	/**
	 * Print a String to the specified text line starting at the specified column.
	 * @param line Line to print on, 1-based
	 * @param col Column to start printing on, 1-based.
	 * @param message String to print with optional format specifiers for listed parameters.
	 * @param parms Parameter list matching format specifiers.
	 */
	public static void print(int line, int col, String message, Object... parms)
	{
		lcd.drawString(String.format(message, parms), col - 1, line - 1);
		lcd.refresh();
	}
}
