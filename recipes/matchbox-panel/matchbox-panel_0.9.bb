DESCRIPTION = "Matchbox Window Manager Panel"
LICENSE = "GPL"
DEPENDS = "libmatchbox virtual/libx11 libxext libxpm apmd startup-notification virtual/kernel"
SECTION = "x11/wm"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify --enable-small-icons"

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"


SRC_URI[md5sum] = "709bde40465d44eb12db7e74c1a2d1fe"
SRC_URI[sha256sum] = "23247d33e26c95a7501908a9e907da05cd004faabd6cf39dd0efb8d4142fbb0c"
