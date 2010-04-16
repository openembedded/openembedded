DESCRIPTION = "USB Device Firmware Upgrade utility (special atmel-version)"
SECTION = "devel"
AUTHOR = "Weston Schmidt <weston_schmidt@alumni.purdue.edu>"
LICENSE = "GPL"

SRCREV = "93"
PV = "0.5.2+svnr${SRCPV}"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

DEPENDS = "libusb"

SRC_URI = "svn://${PN}.svn.sourceforge.net/svnroot/${PN}/;module=trunk;proto=http"
S = "${WORKDIR}/trunk/${PN}"

inherit autotools
