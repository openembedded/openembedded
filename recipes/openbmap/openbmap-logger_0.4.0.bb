DESCRIPTION = "openBmap logger and uploader of GPS/GSM data"
SECTION = "x11/utils"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/myposition/openbmap-logger-${PV}.tar.gz"

inherit distutils

RDEPENDS = "python python-dbus python-pygobject python-pygtk libglade \
	python-subprocess python-netclient python-math python-core python-io frameworkd"

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "52b71c33ce0d2da8d5c29db293132630"
SRC_URI[sha256sum] = "93820366128b394d84b1b37830344b70f349c2896b60b601e884f9d857ff5d84"
