/**
 * <h1>Jusb v1.0.0 (c) 2022</h1> 
 * Interact with devices connected via USB in Java 
 */
package com.grephq.ot;

/**
 * @author Olorunfemi-Ojo Tomiwa
 * @version v1.0.0
 * @since 12-2022
 */
public class Jusb {
	
	static {
		System.loadLibrary("Jusb");
	}
	
	/** USB device vendor ID */
	public int vendorID;
	
	/** USB device product ID */
	public int productID;
	
	
	public Jusb(int vendorID, int productID) {
		this.vendorID = vendorID;
		this.productID = productID;
	}
	
	
	/**
	 * Creates a device handle for device
	 */
	public static native int open();
	
	/**
	 * Get the address of the device on the bus it is connected to
	 * @return int
	 */
	public static native int getDeviceAddress();
	
	/**
	 * Returns the number of USB devices currently attached to the system
	 * @return int
	 */
	public static native int getDeviceList();
	
	/**
	 * Get the negotiated connection speed for a device
	 * @return int
	 */
	public static native int getDeviceSpeed();
	
	/**
	 * Get the number of the port that a device is connected to
	 * @return int
	 */
	public static native int getPortNumber();
	
	/**
	 * Determine the bConfigurationValue of the currently active configuration
	 * @return int
	 */
	public static native int getConfiguration();
	
	/**
	 * Retrieve a descriptor from a device
	 * @return int
	 */
	public static native int getDescriptor();
	
	/**
	 * Get the number of the bus the device is connected to
	 * @return int
	 */
	public static native int getBusNumber();
	
	/**
	 * Frees a list of devices previously discovered
	 */
	public static native void freeDeviceList();
	
	/**
	 * Set the active configuration for a device
	 * @param configuration
	 * @return int
	 */
	public static native int setConfiguration(int configuration);
	
	/**
	 * Log message levels
	 * @param level
	 */
	public static native void setDebug(int level);
	
	/**
	 * Attempt to restore previous configurations
	 * @return int
	 */
	public static native int resetDevice();
	
	/**
	 * Close a device handle
	 */
	public static native void close();
}
