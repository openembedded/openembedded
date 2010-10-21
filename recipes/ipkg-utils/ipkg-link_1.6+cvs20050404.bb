SECTION = "base"
DESCRIPTION = "Itsy Package Manager utilities link script"
LICENSE = "GPLv2+"
CONFLICTS = "ipkg-utils"
SRCDATE = "20050930"
PR = "r4"

SRC_URI = "${HANDHELDS_CVS};module=ipkg-utils \
	   file://link-vfat-libs.patch"

S = "${WORKDIR}/ipkg-utils"

do_compile() {
	:
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ipkg-link ${D}${bindir}
}
