DESCRIPTION = "OfflineIMAP is a tool to simplify your e-mail reading."
HOMEPAGE = "http://gopher.quux.org:70/devel/offlineimap"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/network"
LICENSE = "GPL PSF"
RDEPENDS = "python-re python-netclient python-lang \
            python-threading python-stringold python-crypt python-mailbox"

SRC_URI = "${DEBIAN_MIRROR}/main/o//offlineimap/offlineimap_${PV}.tar.gz"
S = "${WORKDIR}/offlineimap"

inherit distutils

do_install_append() {
	sed -i -e 's|#!.*/python|#!${bindir}/python|' ${D}${bindir}/offlineimap
}
