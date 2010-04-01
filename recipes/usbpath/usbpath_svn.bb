DESCRIPTION = "Convert the physical locations of a USB device to/from its number"
AUTHOR = "Werner Almesberger <werner@openmoko.org>"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "virtual/libusb0"

SRCREV = "3172"
PV = "0.0+svnr${SRCPV}"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host;module=usbpath;proto=http"

S = "${WORKDIR}/usbpath"

inherit autotools

do_stage () {
	autotools_stage_all
}

