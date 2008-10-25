TARGET_CC_ARCH = "-march=armv6j -mtune=arm1136jf-s -mfpu=vfp -mfloat-abi=softfp"
FEED_ARCH = "armv6"
BASE_PACKAGE_ARCH = "armv6"
PACKAGE_EXTRA_ARCHS += "armv4 armv4t armv5te armv6"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc
