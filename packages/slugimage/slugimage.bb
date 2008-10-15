# slugimage - normally built native, a perl script
SECTION = "console/utils"
LICENSE = "BSD"
DESCRIPTION = "Slugimage is a small app to disassemble and reassemble \
flash images for the Linksys NSLU2 device. It also has jffs2 support"
PR = "r12"

RDEPENDS = "perl"

SLUGIMAGE_SVN_REV  ?= "104"
SLUGIMAGE_SVN_REPO ?= "http://svn.nslu2-linux.org/svnroot/slugimage/trunk"

addtask svnfetch before do_configure after do_patch

do_svnfetch() {
	svn co ${SLUGIMAGE_SVN_REPO} --revision ${SLUGIMAGE_SVN_REV} ${WORKDIR}
}

S = "${WORKDIR}"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 slugimage ${D}${bindir}/
}
