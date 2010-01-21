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


