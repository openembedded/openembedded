DESCRIPTION = "Coherence is a DLNA/UPnP mediaserver + backends"
SECTION = "python/devel"
LICENSE = "MIT"
HOMEPAGE = "http://coherence.beebits.net/wiki"

PR = "r0"
PV = "0.6.0+svnr${SRCREV}"
DEFAULT_PREFERENCE = "-1"

inherit setuptools

SRC_URI = "svn://coherence.beebits.net/svn/trunk;module=Coherence;proto=https"
S = "${WORKDIR}/Coherence"

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-gst python-dbus python-configobj python-twisted python-twisted-core python-misc python-zopeinterface zope python-modules"


