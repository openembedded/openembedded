SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager common files"
LICENSE = "GPL"
DEPENDS = "libmatchbox"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-common/${PV}/matchbox-common-${PV}.tar.bz2"
S = "${WORKDIR}/matchbox-common-${PV}"

inherit autotools  pkgconfig

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox/vfolders \
	       ${datadir}/pixmaps"
