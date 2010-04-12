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

SRC_URI[md5sum] = "c379c781ac05d3b64228f48362aecaca"
SRC_URI[sha256sum] = "d2a482d4b7bce5cc41bacddc8ef48ebd21fecbe6585b74036e432c030595b11f"
