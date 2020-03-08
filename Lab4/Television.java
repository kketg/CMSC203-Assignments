/**
* The purpose of this class is to model a television
* @author Kristofer Ter-Gabrielyan
* @since 3/7/2020
*/

public class Television {
	//Manufacturer name
	private final String MANUFACTURER;
	//Size of the screen
	private final int SCREEN_SIZE;
	//Power toggle
	private boolean powerOn;
	//Channel number
	private int channel;
	//Volume level
	private int volume;

	/**
	 *
	 * @param manufacturer manufacturer name
	 * @param size screen size
	 * This creates a new TV object, with initialized fields, including power being off, volume at 20, and channel at 2.
	 */
	public Television(String manufacturer, int size) {
		MANUFACTURER = manufacturer;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	/**
	 * Sets the channel
	 * @param station channel number
	 */
	public void setChannel(int station) {
		channel = station;
	}
	/**
	 * Toggles the powerOn value
	 */
	public void power() {
		powerOn = !powerOn;
	}
	/**
	 * Increments the volume by 1
	 */
	public void increaseVolume() {
		volume++;
	}
	/**
	 * Decrements the volume by 1
	 */
	public void decreaseVolume() {
		volume--;
	}
	/**
	 * @return channel
	 */
	public int getChannel() {
		return channel;
	}
	/**
	 * @return volume
	 */
	public int getVolume() {
		return volume;
	}
	/**
	 * @return manufacturer name
	 */
	public String getManufacturer() {
		return MANUFACTURER;
	}
	/**
	 * @return screen size
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
}
