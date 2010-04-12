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

SRC_URI[md5sum] = "41d9da556205c7cfcb86362387fa6493"
SRC_URI[sha256sum] = "5002223fd102fc5bd454a8b62feb9d281f454769624a071804d6bfc82416a0b4"
