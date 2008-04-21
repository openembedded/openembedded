DESCRIPTION = "RFID library"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libusb"
SRCNAME = "librfid"

PV = "0.2.0+svnr${SRCREV}"

SRC_URI = "svn://svn.gnumonks.org/trunk;module=${SRCNAME};proto=http \
           file://mifare_ul_timeout.patch;patch=1"

S = "${WORKDIR}/${SRCNAME}"

inherit autotools

do_stage() {
	autotools_stage_all
}
