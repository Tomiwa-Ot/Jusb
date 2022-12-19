package com.grephq.ot;

/**
 * Speed codes. Indicates the speed at which the device is operating
 * @author Olorunfemi-Ojo Tomiwa
 */
public class JusbSpeed {
	
	/** The OS doesn't report or know the device speed */
	public static final int UNKNOWN = 0;
	
	/** The device is operating at low speed (1.5MBits/s) */
	public static final int LOW = 1;
	
	/** The device is operating at full speed (12MBits/s) */
	public static final int FULL = 2;
	
	/** The device is operating at high speed (480MBits/s) */
	public static final int HIGH = 3;
	
	/** The device is operating at super speed (5000MBits/s) */
	public static final int SUPER = 4;
	
	/** The device is operating at low speed (10000MBits/s) */
	public static final int SUPER_PLUS = 5;

}
