SRC_URI = "http://www.openchrome.org/releases/xf86-video-openchrome-${PV}.tar.gz file://configure.patch;patch=1 file://configure-dri.patch;patch=1"
PACKAGES_DYNAMIC = "xorg-driver-openchrome"

include openchrome.inc

SRC_URI[md5sum] = "6e3ea28e0b0baf3dc1230da4e1a850ea"
SRC_URI[sha256sum] = "f645da4120b3ad5356b46269ae13ef8e2315bbb443a8c147e05c611f7fa21df7"
