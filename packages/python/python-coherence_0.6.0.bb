DESCRIPTION = "Coherence is a DLNA/UPnP mediaserver + backends"
SECTION = "python/devel"
LICENSE = "MIT"
HOMEPAGE = "http://coherence.beebits.net/wiki"
PR = "r3"

inherit setuptools

SRC_URI = "http://coherence.beebits.net/download/Coherence-${PV}.tar.gz"
S = "${WORKDIR}/Coherence-${PV}"

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-twisted python-twisted-core python-misc python-zopeinterface zope python-modules"


