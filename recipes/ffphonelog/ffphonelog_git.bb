DESCRIPTION = "Finger friendly phonelog"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
HOMEPAGE = "http://www.opkg.org/package_343.html"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "libeflvala"
RDEPENDS_${PN} = "phoneuid"
PV = "0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/ffphonelog.git;protocol=http;branch=master"

SRCREV = "9f7b682c4be9c0f23908dc888462399d939ffa11"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps"

EXTRA_OEMAKE = " \
	CC='${CC}' \
	CFLAGS_APPEND='${CFLAGS}' \
	LDFLAGS_APPEND='${LDFLAGS}' \
	DESTDIR='${D}' \
	PREFIX=/usr"

do_install() {
       oe_runmake install
}

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
