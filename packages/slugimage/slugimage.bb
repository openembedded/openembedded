SECTION = "unknown"
LICENSE = "BSD"
DESCRIPTION = "Slugimage is a small app to disassemble and reassemble \
flash images for the Linksys NSLU2 device. It also has jffs2 support"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r3"

RDEPENDS = "perl-native"

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/nslu;module=slugimage;tag=SLUGIMAGE_3_2"
S = "${WORKDIR}"


do_install () {
	install -d ${D}${bindir}
	install -m 0755 slugimage/slugimage ${D}${bindir}/
}
