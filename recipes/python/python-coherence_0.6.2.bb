DESCRIPTION = "Coherence is a DLNA/UPnP mediaserver + backends"
SECTION = "devel/python"
LICENSE = "MIT"
HOMEPAGE = "http://coherence.beebits.net/wiki"
PR = "r1"

inherit setuptools

SRC_URI = "http://coherence.beebits.net/download/Coherence-${PV}.tar.gz"
S = "${WORKDIR}/Coherence-${PV}"

FILES_${PN} += "${datadir}"

DEPENDS = "libxml2 libxml2-native"
RDEPENDS_${PN} += "python-twisted-pair python-divmodepsilon python-nevow python-gst python-dbus \
	python-configobj python-twisted python-twisted-core python-twisted-protocols python-misc \
	python-zopeinterface python-modules python-pygobject python-gdata \
	python-divmodaxiom"



SRC_URI[md5sum] = "feaeeaa68cae420c0c365c3c27b2a21e"
SRC_URI[sha256sum] = "1cb99720527ea0a5906f5e75152634b1797ff44bcc31f4014285bd5da41589cc"
