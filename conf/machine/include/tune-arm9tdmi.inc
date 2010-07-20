FEED_ARCH = "armv4t"
BASE_PACKAGE_ARCH = "armv4t"
PACKAGE_EXTRA_ARCHS += "armv4 armv4t"
TARGET_CC_ARCH = "-mcpu=arm9tdmi -mtune=arm9tdmi"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc

