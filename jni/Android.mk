LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

OPENCV_LIB_TYPE:=STATIC
OPENCV_INSTALL_MODULES:=on

OPENCV_MK_PATH:=/opt/android-opencv/OpenCV-2.4.1/share/opencv/OpenCV.mk
#ifeq ("$(wildcard $(OPENCV_MK_PATH))","")
	#try to load OpenCV.mk from default install location
	#include $(TOOLCHAIN_PREBUILT_ROOT)/user/share/OpenCV/OpenCV.mk
#else
include $(OPENCV_MK_PATH)
#endif

LOCAL_MODULE    := opencv-jni
LOCAL_SRC_FILES := opencv-jni.cpp
LOCAL_LDLIBS +=  -llog -ldl

include $(BUILD_SHARED_LIBRARY)
