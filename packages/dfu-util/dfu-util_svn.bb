DESCRIPTION = "USB Device Firmware Upgrade utility"
SECTION = "devel"
AUTHOR = "Harald Welte"
LICENSE = "GPL"
PV = "0.1+svn${SRCDATE}"
PR = "r0"

DEPENDS = "libusb"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=dfu-util;proto=http"
S = "${WORKDIR}/dfu-util"

inherit autotools

do_stage() {
	autotools_stage_all
}
