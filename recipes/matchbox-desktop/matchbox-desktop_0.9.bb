DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${libdir}/matchbox/desktop/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps \
	       ${sysconfdir}/matchbox"

FILES_${PN}-dev = "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${datadir}/matchbox/desktop/modules/*a"

SRC_URI[md5sum] = "5621a74ac59ef1a42e0e1971ec996e1a"
SRC_URI[sha256sum] = "b104d1bda4b68a49f22106d8c0692961f7a2c39e839caf6e968cf870d7c0ec7b"
