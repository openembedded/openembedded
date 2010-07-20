TARGET_ARCH = "arm"
TARGET_CC_ARCH = "-march=armv6j -mtune=arm1136jf-s"

# Not all kernels enable floating point emulation in the kernel, so we exclude 'armv6' for now
FEED_ARCH = "armv6-novfp"
BASE_PACKAGE_ARCH = "armv6-novfp"
PACKAGE_EXTRA_ARCHS += "armv4 armv4t armv5te armv6-novfp"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc
