TARGET_CC_ARCH = "-mcpu=ep9312 -mfpu=maverick -mfloat-abi=softfp -fno-signed-zeros -O"

#set arch to ep9312 for all generated packages
PACKAGE_EXTRA_ARCHS += "armv4t"
BASE_PACKAGE_ARCH = "ep9312"
FEED_ARCH = "ep9312"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc

