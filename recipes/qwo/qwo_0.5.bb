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
