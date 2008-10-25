FEED_ARCH =  "${@['armv5teb', 'armv5te'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"

TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"
TARGET_CC_KERNEL_ARCH = "-march=armv5te -mtune=xscale"
PACKAGE_EXTRA_ARCHS += "${@['armv4b armv4tb armv5teb', 'armv4 armv4t armv5te'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"
BASE_PACKAGE_ARCH = "${@['armv5teb', 'armv5te'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"

# Include tune file for thumb support, it defaults to off so DISTROs can turn it on if they wish
require conf/machine/include/tune-thumb.inc

