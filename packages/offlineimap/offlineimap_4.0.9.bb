DESCRIPTION = "OfflineIMAP is a tool to simplify your e-mail reading."
HOMEPAGE = "http://gopher.quux.org:70/devel/offlineimap"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/network"
LICENSE = "GPL PSF"

SRC_URI = "${DEBIAN_MIRROR}/main/o//offlineimap/offlineimap_${PV}.tar.gz"
S = "${WORKDIR}/offlineimap"

inherit distutils
