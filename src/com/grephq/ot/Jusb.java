/**
 * <h1>Jusb v1.0.0 (c) 2022</h1> 
 * Interact with devices connected via USB in Java 
 */
package com.grephq.ot;

/**
 * Java wrapper for libusb
 *
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
	 * Initialize libusb
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__lib.html#ga7deaef521cfb1a5b3f8d6c01be11a795">Documentation</a>
	 */
	public static native int init();
	
	/**
	 * Creates a device handle for device
	 * @param vendorID the idVendor value to search fo
	 * @param productID the idProduct value to search for
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#ga10d67e6f1e32d17c33d93ae04617392e">Documentation</a>
	 */
	public static native int open(int vendorID, int productID);
	
	/**
	 * Get the address of the device on the bus it is connected to
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gab6d4e39ac483ebaeb108f2954715305d">Documentation</a>
	 */
	public static native int getDeviceAddress();
	
	/**
	 * Returns the number of USB devices currently attached to the system
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gac0fe4b65914c5ed036e6cbec61cb0b97">Documentation</a>
	 */
	public static native int getDeviceList();
	
	/**
	 * Get the negotiated connection speed for a device
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#ga58c4e448ecd5cd4782f2b896ec40b22b">Documentation</a>
	 */
	public static native int getDeviceSpeed();
	
	/**
	 * Get the number of the port that a device is connected to
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#ga14879a0ea7daccdcddb68852d86c00c4">Documentation</a>
	 */
	public static native int getPortNumber();
	
	/**
	 * Determine the bConfigurationValue of the currently active configuration
	 * @param configuration output location for the bConfigurationValue of the active configuration (only valid for return code 0)
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gae921014b888b105471a31d54c77c1c4d">Documentation</a>
	 */
	public static native int getConfiguration(int configuration);
	
	/**
	 * Retrieve a descriptor from a device
	 * @param desc_type the descriptor type
	 * @param desc_index the index of the descriptor to retrieve
	 * @param data output buffer for descriptor
	 * @param length size of data buffer
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__desc.html#ga9e34f7ecf3817e9bfe77ed09238940df">Documentation</a>
	 */
	public static native int getDescriptor(int desc_type, int desc_index, char data, int length);
	
	/**
	 * Get the number of the bus the device is connected to
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gaf2718609d50c8ded2704e4051b3d2925">Documentation</a>
	 */
	public static native int getBusNumber();
	
	/**
	 * Frees a list of devices previously discovered
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gad3b8561d064bb3e1b8851ddeed3cd7d6">Documentation</a>
	 */
	public static native void freeDeviceList();
	
	/**
	 * Set the active configuration for a device
	 * @param configuration the bConfigurationValue of the configuration you wish to activate, or -1 if you wish to put the device in an unconfigured state
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#ga785ddea63a2b9bcb879a614ca4867bed">Documentation</a>
	 */
	public static native int setConfiguration(int configuration);
	
	/**
	 * Log message levels
	 * @param level debug level
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__lib.html#ga5f8376b7a863a5a8d5b8824feb8a427a">Documentation</a>
	 */
	public static native void setDebug(int level);
	
	/**
	 * Attempt to restore previous configurations
	 * @return int
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#gafee9c4638f1713ca5faa867948878111">Documentation</a>
	 */
	public static native int resetDevice();
	
	/**
	 * Close a device handle
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__dev.html#ga779bc4f1316bdb0ac383bddbd538620e">Documentation</a>
	 */
	public static native void close();

	/**
	 * Deinitialize libusb
	 * @see <a href="https://libusb.sourceforge.io/api-1.0/group__libusb__lib.html#ga7deaef521cfb1a5b3f8d6c01be11a795">Documentation</a>
	 */
	public static native void exit();
}
