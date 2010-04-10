DESCRIPTION = "OfflineIMAP is a tool to simplify your e-mail reading."
HOMEPAGE = "http://gopher.quux.org:70/devel/offlineimap"
LICENSE = "GPL"
SECTION = "console/network"
LICENSE = "GPL PSF"
RDEPENDS = "python-re python-netclient python-lang \
            python-threading python-stringold python-crypt python-mailbox"

SRC_URI = "${DEBIAN_MIRROR}/main/o/offlineimap/offlineimap_${PV}.tar.gz"
S = "${WORKDIR}/offlineimap"

inherit distutils

do_install_append() {
	sed -i -e 's|#!.*/python|#!${bindir}/python|' ${D}${bindir}/offlineimap
}

SRC_URI[md5sum] = "b374415d7f5d485993fa697ab9a678b4"
SRC_URI[sha256sum] = "3b46936339fe5c2dcb8fb2f9213fa36dcddefaa1e00d1d93b5640d8cc9898ca1"
