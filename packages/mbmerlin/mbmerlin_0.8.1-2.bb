LICENSE = "GPL"
PR = "r3"

inherit pkgconfig gpe

DEPENDS = "virtual/xserver libxft startup-notification"

SECTION = "x11"
PRIORITY = "optional"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/mbmerlin ${datadir}/applications"
FILES_${PN} += " ${datadir}/pixmaps"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://fix_makefile.patch;patch=1"

S = "${WORKDIR}/mbmerlin"

CFLAGS += " -D_GNU_SOURCE"
