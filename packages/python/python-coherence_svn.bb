DESCRIPTION = "Coherence is a DLNA/UPnP mediaserver + backends"
SECTION = "devel/python"
LICENSE = "MIT"
HOMEPAGE = "http://coherence.beebits.net/wiki"

PR = "r6"
PV = "0.6.0+svnr${SRCREV}"

inherit setuptools

SRC_URI = "svn://coherence.beebits.net/svn/trunk;module=Coherence;proto=https"
S = "${WORKDIR}/Coherence"

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-twisted-pair python-divmodepsilon python-nevow python-gst python-dbus \
	python-configobj python-twisted python-twisted-core python-misc python-zopeinterface \
	zope python-modules python-pygobject python-gdata python-inotify"


