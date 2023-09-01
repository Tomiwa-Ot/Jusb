#include <jni.h>
#include <stdio.h>
#include <libusb.h>
#include "com_grephq_ot_Jusb.h"


libusb_context *ctx = NULL;
libusb_device_handle *dev_handle = NULL;
libusb_device *device = NULL;

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_init(JNIEnv *, jclass) {
    return libusb_init(&ctx);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_open(JNIEnv *, jclass, jint vendorID, jint productID) {
    // Open a USB device
    dev_handle = libusb_open_device_with_vid_pid(ctx, vendorID, productID);
    if (dev_handle == NULL) {
        libusb_exit(ctx);
        return 1;
    }

    device = libusb_get_device(dev_handle);

    return 0;
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceAddress(JNIEnv *, jclass) {
    return libusb_get_device_address(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceList(JNIEnv *, jclass) {

}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceSpeed(JNIEnv *, jclass) {
    return libusb_get_device_speed(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getPortNumber(JNIEnv *, jclass) {
    return  libusb_get_port_number(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getConfiguration(JNIEnv *, jclass, jint configuration) {
    return libusb_get_configuration (dev_handle, configuration);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDescriptor(JNIEnv *, jclass, jint desc_type, jint desc_index, jchar data, jint length) {
    return libusb_get_descriptor(dev_handle, uint8_t desc_type, uint8_t desc_index, unsigned char * data, int length);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getBusNumber(JNIEnv *, jclass) {
    return libusb_get_bus_number(device);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_freeDeviceList(JNIEnv *, jclass) {

}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_setConfiguration(JNIEnv *, jclass, jint configuration) {
    return libusb_set_configuration(dev_handle, int configuration);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_setDebug(JNIEnv *, jclass, jint debugLevel) {
    libusb_set_debug(ctx, int debugLevel);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_resetDevice(JNIEnv *, jclass) {
    return libusb_reset_device(dev_handle);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_close(JNIEnv *, jclass) {
    libusb_close(dev_handle);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_exit(JNIEnv *, jclass) {
    libusb_exit(ctx);
}