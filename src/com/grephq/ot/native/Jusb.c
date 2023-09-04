#include <jni.h>
#include <stdio.h>
#include <libusb.h>
#include "com_grephq_ot_Jusb.h"

// gcc -fPIC -shared -o libusbjava.so -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -I/usr/include/libusb-1.0 Jusb.c

libusb_context *ctx = NULL;
libusb_device_handle *dev_handle = NULL;
libusb_device *device = NULL;

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_init(JNIEnv *env, jclass obj) {
    return libusb_init(&ctx);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_open(JNIEnv *env, jclass obj, jint vendorID, jint productID) {
    // Open a USB device
    dev_handle = libusb_open_device_with_vid_pid(ctx, vendorID, productID);
    if (dev_handle == NULL) {
        libusb_exit(ctx);
        return 1;
    }

    device = libusb_get_device(dev_handle);

    return 0;
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceAddress(JNIEnv *env, jclass obj) {
    return libusb_get_device_address(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceList(JNIEnv *env, jclass obj) {
    libusb_device** devicePtr = &device;
    return libusb_get_device_list(ctx, &devicePtr);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDeviceSpeed(JNIEnv *env, jclass obj) {
    return libusb_get_device_speed(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getPortNumber(JNIEnv *env, jclass obj) {
    return  libusb_get_port_number(device);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getConfiguration(JNIEnv *env, jclass obj, jint configuration) {
    return libusb_get_configuration (dev_handle, configuration);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getDescriptor(JNIEnv *env, jclass obj, jint desc_type, jint desc_index, jchar data, jint length) {
    return libusb_get_descriptor(dev_handle, desc_type, desc_index, (char)data, length);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_getBusNumber(JNIEnv *env, jclass obj) {
    return libusb_get_bus_number(device);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_freeDeviceList(JNIEnv *env, jclass obj, jint unref_devices) {
    libusb_free_device_list(&device, unref_devices);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_setConfiguration(JNIEnv *env, jclass obj, jint configuration) {
    return libusb_set_configuration(dev_handle, configuration);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_setDebug(JNIEnv *env, jclass obj, jint debugLevel) {
    libusb_set_debug(ctx, debugLevel);
}

JNIEXPORT jint JNICALL Java_com_grephq_ot_Jusb_resetDevice(JNIEnv *env, jclass obj) {
    return libusb_reset_device(dev_handle);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_close(JNIEnv *env, jclass obj) {
    libusb_close(dev_handle);
}

JNIEXPORT void JNICALL Java_com_grephq_ot_Jusb_exit(JNIEnv *env, jclass obj) {
    libusb_exit(ctx);
}