DESCRIPTION = "The SHR DBus API Specification"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "2752ded90581cfd2259ab65be7f9c2b9fb4a2638"
PV = "2010.12.27.1+gitr${SRCPV}"

SRC_URI = "git://git.shr-project.org/repo/shr-specs.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/shr-specs"


