# GCC 4.3.0- (see Poky)
# TARGET_CC_ARCH = "-march=i586"
# GCC 4.3.1+ (see Gentoo)
TARGET_CC_ARCH = "-march=core2"
# GCC 4.4.2+ (see Fedora 12)
#TARGET_CC_ARCH = "-march=i686 -mtune=atom"
BASE_PACKAGE_ARCH = "i686"
FEED_ARCH = "i686"
PACKAGE_EXTRA_ARCHS += "x86 i386 i486 i586"