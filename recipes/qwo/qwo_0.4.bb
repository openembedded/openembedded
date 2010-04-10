DESCRIPTION = "qwo virtual keyboard"
AUTHOR = "Charles Clement"
HOMEPAGE = "http://www.nongnu.org/qwo/"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "libxtst libxext virtual/imlib2 libconfig"
RDEPENDS += "imlib2-loaders"
PV = "0.4"
PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/qwo/qwo-${PV}.tar.gz \
	   file://check_lib.patch;patch=1 \
          "

inherit autotools

SRC_URI[md5sum] = "72811b7d7fecfbdca45d5a74394daa4f"
SRC_URI[sha256sum] = "c3b9bffd3e27090d4c0623ef61f48257343d0f6ea1cf573f5296250ab7551e5d"
