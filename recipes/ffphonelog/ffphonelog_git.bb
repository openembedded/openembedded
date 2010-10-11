DESCRIPTION = "Finger friendly phonelog"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
HOMEPAGE = "http://www.opkg.org/package_343.html"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "libeflvala"
RDEPENDS_${PN} = "phoneuid"
PV = "0.1+gitr${SRCPV}"

SRC_URI = "git://git.shr-project.org/repo/ffphonelog.git;protocol=http;branch=master"

SRCREV = "d59853f8f777d943c0e3791c1d17af82d794040c"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps"

do_install() {
       oe_runmake install DESTDIR=${D}
}

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
