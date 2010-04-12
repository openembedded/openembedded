SECTION = "x11/wm"
PR = "r1"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-desktop/0.8/matchbox-desktop-${PV}.tar.bz2"


EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/matchbox/desktop/modules/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps"

FILES_${PN}-dev = "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${datadir}/matchbox/desktop/modules/*a"

SRC_URI[md5sum] = "7b2aab7fc14b8690b436a22a6c041695"
SRC_URI[sha256sum] = "bced4bcb32dba30feee0da6e4d7c726f4c0c72dc29c2d7bbb648f9208357bc19"
