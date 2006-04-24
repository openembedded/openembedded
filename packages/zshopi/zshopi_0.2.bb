DESCRIPTION = "Shopping manager"
SECTION = "opie/applications"
DEPENDS = "sqlite opie-lrelease-native"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://www.lachner-net.de/"
AUTHOR = "Bernd Lachner <dev@lachner-net.de>"
APPTYPE = "binary"
APPNAME = "zshopi"
APPDESKTOP = "${WORKDIR}"
PR = "r1"

SRC_URI = "http://www.lachner-net.de/Frames/Software/zshopi_0.2.tar.bz2 \
file://zshopi.desktop \
file://zshopi.png"

S = "${WORKDIR}/${PN}_${PV}/${PN}/"

PACKAGES_prepend = "zshopi-i18n-de "

FILES_zshopi-i18n-de = "/opt/QtPalmtop/i18n/*"

inherit opie

EXTRA_QMAKEVARS_POST += "DEFINES+=QTOPIA LIBS+=-lm LIBS+=-lsqlite LIBS+=-lqpe"
OE_QMAKE_CXXFLAGS = "-fno-rtti ${CXXFLAGS}"

do_configure_prepend() {
	qmake -project
}

do_install() {

	cd "${WORKDIR}/${PN}_${PV}/zshopi"	
	opie-lrelease zshopi.de.ts

	
	install -d ${D}${palmtopdir}/i18n/de	
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 ${WORKDIR}/zshopi.png ${D}${palmtopdir}/pics/	
	install -m 0644 ${WORKDIR}/${PN}_${PV}/zshopi/zshopi.de.qm ${D}${palmtopdir}/i18n/de/zshopi.qm
}
