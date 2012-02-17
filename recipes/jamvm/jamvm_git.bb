# Note: You *must* use this together with classpath-native 0.98.
# Otherwise it won't work!

require jamvm.inc

SRCREV = "4617da717ecb05654ea5bb9572338061106a414d"
PV = "1.5.5+1.6.0-devel+git${SRCPV}"

SRC_URI = "git://git.berlios.de/jamvm;protocol=git \
           file://jamvm-jni_h-noinst.patch \
           file://libffi.patch \
          "

S = "${WORKDIR}/git"

