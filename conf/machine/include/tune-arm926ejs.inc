FEED_ARCH = "armv5te"
PACKAGE_EXTRA_ARCHS += "armv4 armv4t armv5te"
# For gcc 3.x you need:
#TARGET_CC_ARCH = "-march=armv5te -mtune=arm926ejs"
# For gcc 4.x you need:
TARGET_CC_ARCH = "-march=armv5te -mtune=arm926ej-s"
BASE_PACKAGE_ARCH = "armv5te"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc
