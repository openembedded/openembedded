DESCRIPTION = "This tool allows you to search, index and record/stream BBC iPlayer and more"
LICENSE = "GPLv3"

RDEPENDS_${PN} = "flvstreamer libhtml-parser-perl libwww-perl perl-modules"
PACKAGE_ARCH_${PN} = "all"

SRC_URI = "http://linuxcentre.net/get_iplayer/get_iplayer-2.64/get_iplayer"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/get_iplayer ${D}${bindir}
}

