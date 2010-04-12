DESCRIPTION = "Coherence is a DLNA/UPnP mediaserver + backends"
SECTION = "devel/python"
LICENSE = "MIT"
HOMEPAGE = "http://coherence.beebits.net/wiki"
PR = "r0"

inherit setuptools

SRC_URI = "http://coherence.beebits.net/download/Coherence-${PV}.tar.gz"
S = "${WORKDIR}/Coherence-${PV}"

FILES_${PN} += "${datadir}"

DEPENDS = "libxml2 libxml2-native"
RDEPENDS_${PN} += "python-twisted-pair python-divmodepsilon python-nevow python-gst python-dbus \
	python-configobj python-twisted python-twisted-core python-twisted-protocols python-misc \
	python-zopeinterface python-modules python-pygobject python-gdata \
	python-divmodaxiom"



SRC_URI[md5sum] = "d7a1b4abf6831c61e37a3b9e2bdc560a"
SRC_URI[sha256sum] = "0b54a6ba88c1ff6274aadb68ff37b8a3961b4c6acf5ded291c5dea936a311ba4"
