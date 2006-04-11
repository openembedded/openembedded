SECTION = "base"
DESCRIPTION = "Itsy Package Manager utilities link script"
LICENSE = "GPL"
CONFLICTS = "ipkg-utils"
PV_append = "${CVSDATE}"
PACKAGE_ARCH = "all"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=ipkg-utils \
	   file://link-vfat-libs.patch;patch=1"
	   	   
S = "${WORKDIR}/ipkg-utils"

do_compile() {
	:
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ipkg-link ${D}${bindir}
}
