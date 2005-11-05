DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox x11 xext xpm apmd startup-notification virtual/kernel"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify --enable-small-icons"

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

