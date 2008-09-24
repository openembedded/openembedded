DESCRIPTION = "Remoko -- Bluetooth Remote Control"
HOMEPAGE = "http://code.google.com/p/remoko/"
AUTHOR = "Valério Valério"
LICENSE = "GPL"
SECTION = "console/network"
PV = "0.3.1+svn${SRCREV}"

SRC_URI = "svn://remoko.googlecode.com/svn/trunk;module=BT_HID_UI;proto=http"
S = "${WORKDIR}/BT_HID_UI"

inherit distutils

RDEPENDS = "remoko-server"
FILES_${PN} += "${datadir}"

