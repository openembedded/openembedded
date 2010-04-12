SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager common files"
LICENSE = "GPL"
DEPENDS = "libmatchbox"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz"

inherit autotools  pkgconfig

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox/vfolders \
	       ${datadir}/pixmaps"

SRC_URI[md5sum] = "42f76caa0d51ecefc92979fc659ac29c"
SRC_URI[sha256sum] = "9ceab55677a404db7ca83ae3b3c678fb1f292e0fee055079ad95f967a98a6e04"
