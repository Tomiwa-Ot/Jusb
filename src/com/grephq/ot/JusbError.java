package com.grephq.ot;

/**
 * Error codes
 * @author Olorunfemi-Ojo Tomiwa
 */
public class JusbError {
	
	/** Success (no error) */
	public static final int SUCCESS = 0;
	
	/** Input/output error */
	public static final int ERROR_IO = -1;
	
	/** Invalid parameter */
	public static final int ERROR_INVALID_PARAM = -2;
	
	/** Access denied (insufficient permissions) */
	public static final int ERROR_ACCESS = -3;
	
	/** No such device (it may have been disconnected) */
	public static final int ERROR_NO_DEVICE = -4;
	
	/** Entity not found */
	public static final int ERROR_NOT_FOUND = -5;
	
	/** Resource busy */
	public static final int ERROR_BUSY = -6;
	
	/** Operation timed out */
	public static final int ERROR_TIMEOUT = -7;
	
	/** Overflow */
	public static final int ERROR_OVERFLOW = -8;
	
	/** Pipe error */
	public static final int ERROR_PIPE = -9;
	
	/** System call interrupted (perhaps due to signal) */
	public static final int ERROR_INTERRUPTED = -10;
	
	/** Insufficient memory */
	public static final int ERROR_NO_MEM = -11;
	
	/** Operation not supported or unimplemented on this platform */
	public static final int ERROR_NOT_SUPPORTED = -12;
	
	/** Other error */
	public static final int ERROR_OTHER = -99;

}
