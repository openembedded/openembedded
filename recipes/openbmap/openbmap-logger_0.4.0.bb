DESCRIPTION = "openBmap logger and uploader of GPS/GSM data"
SECTION = "x11/utils"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/myposition/openbmap-logger-${PV}.tar.gz"

inherit distutils

RDEPENDS = "python python-dbus python-pygobject python-pygtk libglade \
	python-subprocess python-netclient python-math python-core python-io frameworkd"

FILES_${PN} += "${datadir}"
