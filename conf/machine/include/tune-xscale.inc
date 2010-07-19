# this depends on fact that for ARM the TARGET_ARCH is 'arm' for little endian and 'armeb' for bigendian
# this is the case as of now for all arm machines in OE.

FEED_ARCH =  "${@['armv5teb', 'armv5te'][bb.data.getVar('TARGET_ARCH', d, 1) == 'arm']}"

TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"
TARGET_CC_KERNEL_ARCH = "-march=armv5te -mtune=xscale"
PACKAGE_EXTRA_ARCHS += "${@['armv4b armv4tb armv5teb', 'armv4 armv4t armv5te'][ bb.data.getVar('TARGET_ARCH', d, 1) == 'arm']}"
BASE_PACKAGE_ARCH = "${@['armv5teb', 'armv5te'][bb.data.getVar('TARGET_ARCH', d, 1) == 'arm']}"
