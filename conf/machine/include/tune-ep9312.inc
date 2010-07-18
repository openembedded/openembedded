TARGET_CC_ARCH = "-mcpu=ep9312 -mfpu=maverick -mfloat-abi=softfp"

#set arch to ep9312 for all generated packages
PACKAGE_EXTRA_ARCHS += "armv4t ep9312"
BASE_PACKAGE_ARCH = "ep9312"
FEED_ARCH = "ep9312"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O -fno-signed-zeros"
DEBUG_OPTIMIZATION = "-O -fno-omit-frame-pointer -g"
SELECTED_OPTIMIZATION = "${@bb.data.getVar(['FULL_OPTIMIZATION', 'DEBUG_OPTIMIZATION'][bb.data.getVar('DEBUG_BUILD', d, 1) == '1'], d, 1)}"
BUILD_OPTIMIZATION = "-O"
