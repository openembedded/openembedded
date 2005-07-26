DESCRIPTION = "Interface software for the TopField TF5000PVRt"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://sf.net/project/puppy/"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/puppy;module=puppy;tag=PUPPY_1_9"
S = "${WORKDIR}/puppy"

inherit autotools

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/puppy ${D}${bindir}/puppy
}
