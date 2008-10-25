TARGET_CC_ARCH = "-march=ep9312 -mtune=ep9312 -mcpu=ep9312"
# add "-mfp=maverick" for newer gcc versions > 4.0

#set arch to ep9312 for all generated packages
PACKAGE_EXTRA_ARCHS += "armv4 armv4t ep9312"
BASE_PACKAGE_ARCH = "ep9312"
FEED_ARCH = "ep9312"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc

