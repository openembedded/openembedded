DESCRIPTION = "Shopping manager"
SECTION = "opie/applications"
DEPENDS = "sqlite opie-lrelease-native"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.lachner-net.de/"
AUTHOR = "Bernd Lachner <dev@lachner-net.de>"
APPTYPE = "binary"
APPNAME = "zshopi"
APPDESKTOP = "${WORKDIR}"
PR = "r1"

SRC_URI = "http://www.lachner-net.de/old/Frames/Software/zshopi_0.2.tar.bz2 \
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

SRC_URI[md5sum] = "1343c4de6d586a1b4ed2b5c97d53e717"
SRC_URI[sha256sum] = "6a136cbc7fdb38c73fe5862f21913e8fe63864063bba833c149c1098d758a12f"
