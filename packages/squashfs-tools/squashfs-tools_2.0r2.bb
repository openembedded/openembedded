SECTION = "base"
DESCRIPTION = "Squashfs is a highly compressed read-only filesystem for Linux."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tar.gz \
	   file://flags.patch;patch=1"
S = "${WORKDIR}/squashfs${PV}/squashfs-tools"

prefix = ""

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 mksquashfs ${D}${sbindir}/
}
