# Note: You *must* use this together with classpath-native 0.98.
# Otherwise it won't work!

require jamvm-native.inc

PR = "r0"

SRC_URI += "file://jamvm-1.5.3-jni_h-noinst.patch"

SRC_URI[md5sum] = "7654e9657691f5f09c4f481ed4686176"
SRC_URI[sha256sum] = "7865693698bc4322cabe1014a4b7ebdec1bc1daf45f1a4457b6e908a4446b124"
