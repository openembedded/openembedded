SRC_URI = "http://www.openchrome.org/releases/xf86-video-openchrome-${PV}.tar.gz file://configure.patch;patch=1 file://configure-dri.patch;patch=1"
PACKAGES_DYNAMIC = "xorg-driver-openchrome"

include openchrome.inc
