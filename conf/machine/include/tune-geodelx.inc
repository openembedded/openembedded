# Geode CPU has it's own target in GCC 4.3
# in older versions k6-2 is closest
#
TARGET_CC_ARCH = "-march=k6-2"
BASE_PACKAGE_ARCH = "geode"
PACKAGE_EXTRA_ARCHS += "x86 geode"

FEED_ARCH = "geode"

