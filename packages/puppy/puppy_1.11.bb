DESCRIPTION = "Interface software for the TopField TF5000PVRt"
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://sf.net/projects/puppy/"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "cvs://anonymous:@puppy.cvs.sourceforge.net/cvsroot/puppy;module=puppy;tag=PUPPY_1_11 \
	   file://usb-header.patch;patch=1"
S = "${WORKDIR}/puppy"

inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/puppy ${D}${bindir}/puppy
}
