DESCRIPTION = "The SHR DBus API Specification"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "0e50703bcb5bc036fb5b295eceb2b7c6a2f1d455"
PV = "0.0.0+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/shr-specs.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/shr-specs"


