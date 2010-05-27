# This is to be used by recipes which rely on java-library.bbclass
# infrastructure and are a *-native recipe which needs to install
# jar files into staging.
# 
# This class has nothing to do with Java's JNI.

inherit native

NATIVE_INSTALL_WORKS = "1"
