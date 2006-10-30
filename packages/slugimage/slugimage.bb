# slugimage - normally built native, a perl script
SECTION = "console/utils"
LICENSE = "BSD"
DESCRIPTION = "Slugimage is a small app to disassemble and reassemble \
flash images for the Linksys NSLU2 device. It also has jffs2 support"
PR = "r4"

RDEPENDS = "perl"

SRC_URI = "cvs://anonymous:@nslu.cvs.sourceforge.net/cvsroot/nslu;module=slugimage;tag=SLUGIMAGE_3_2"
S = "${WORKDIR}"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 slugimage/slugimage ${D}${bindir}/
}
