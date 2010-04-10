DESCRIPTION = "qwo virtual keyboard"
AUTHOR = "Charles Clement"
HOMEPAGE = "http://www.nongnu.org/qwo/"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "libxtst libxext virtual/imlib2 libconfig"
RDEPENDS += "imlib2-loaders"

SRC_URI = "http://download.savannah.nongnu.org/releases/qwo/qwo-${PV}.tar.gz "

inherit autotools

SRC_URI[md5sum] = "9e1f7394be0a2eb2891e915f594d5f95"
SRC_URI[sha256sum] = "fbb416acee1f8fe56394f37074154138f3cf324f48ce611cc2df40eb73b5c9ff"
