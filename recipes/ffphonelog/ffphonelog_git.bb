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

SRCREV = "f257edad1b046d5efcc83f80c1bef314773c2bc2"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps"

do_install() {
       oe_runmake install DESTDIR=${D}
}

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
