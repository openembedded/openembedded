DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"
PR = "r6"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-desktop/0.9/matchbox-desktop-${PV}.tar.bz2 \
           file://pkgconfig_fix.patch \
           file://mb-desktop-multi-category-matching.patch"

SRC_URI_append_jlime = " file://layout.patch "

RDEPENDS_${PN} += "matchbox-common"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${libdir}/matchbox/desktop/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps \
	       ${sysconfdir}/matchbox"

FILES_${PN}-dev += "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${libdir}/matchbox/desktop/*.*a \
		   ${datadir}/matchbox/desktop/modules/*a"

FILES_${PN}-dbg += "${libdir}/matchbox/desktop/.debug/"

SRC_URI[md5sum] = "3335a30b1a1aacfb39f23b505254765c"
SRC_URI[sha256sum] = "ecb025d3660d80a9850973111b4fdfffaa50b47cbf0c5467b508d28d65146793"
