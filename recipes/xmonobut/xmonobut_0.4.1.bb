DESCRIPTION = "X-Utility to allow middle and right clicking with a stylus"
LICENSE = "GPL"
SECTION = "x11/utils"
DEPENDS = "virtual/libx11 libxext libxpm libmatchbox"
PR = "r1"

SRC_URI = "\
  http://familiar.handhelds.org/source/v0.8.4-rc2/sources/xmonobut-${PV}.tar.gz \
  file://xmonobut.desktop \
"

inherit autotools

#do_install() {
#	install -d ${D}${bindir}
#	install -d ${D}${datadir}/applications
#	install -d ${D}${datadir}/pixmaps
#	install -m 0755 xmonobut ${D}${bindir}/xmonobut
#	install -m 0644 xmonobut.xpm ${D}${datadir}/pixmaps/xmonobut.xpm
#	install -m 0644 ${WORKDIR}/xmonobut.desktop ${D}${datadir}/applications/xmonobut.desktop
#}
