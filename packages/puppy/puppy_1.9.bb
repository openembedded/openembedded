DESCRIPTION = "Interface software for the TopField TF5000PVRt"
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://sf.net/projects/puppy/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "cvs://anonymous:@puppy.cvs.sourceforge.net/cvsroot/puppy;module=puppy;tag=PUPPY_1_9"
S = "${WORKDIR}/puppy"

inherit autotools

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/puppy ${D}${bindir}/puppy
}
