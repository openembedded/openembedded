DESCRIPTION = "Qt/Embedded Fonts Version ${PV}"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-${PV}-free.tar.gz \
	   file://update-qtfontdir"
S = "${WORKDIR}/qt-${PV}"

inherit qpf

QPF_PKGPATTERN = "qte-font-%s"
QPF_DESCRIPTION = "Qt/E font %s"

do_install() {
	install -d ${D}/${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}/${sbindir}/
	install -d ${D}${palmqtdir}/lib/fonts/
	cp -a lib/fonts/* ${D}${palmqtdir}/lib/fonts/
}
