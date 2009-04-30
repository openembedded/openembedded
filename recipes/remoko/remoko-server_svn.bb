DESCRIPTION = "The Remoko HID Server"
HOMEPAGE = "http://code.google.com/p/remoko/"
AUTHOR = "Valério Valério"
LICENSE = "GPL"
SECTION = "console/network"
PV = "0.2.1+svnr${SRCPV}"
PE = "1"

SRC_URI = "svn://remoko.googlecode.com/svn/trunk;module=BT_HID_Server;proto=http"
S = "${WORKDIR}/BT_HID_Server"

inherit autotools
