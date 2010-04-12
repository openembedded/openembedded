# Note: You *must* use this together with classpath-native 0.98. Otherwise it won't work!

require jamvm-native.inc

PR = "r1"

SRC_URI += "file://jamvm-1.5.3-jni_h-noinst.patch;patch=1"


SRC_URI[md5sum] = "ce886163658d748113b0570dfae12aea"
SRC_URI[sha256sum] = "f2795ab62635df1c9bc6c4a7b90f53d0d846c0c26f5ec7b352f687506407ebd8"
