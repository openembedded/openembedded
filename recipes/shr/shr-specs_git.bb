DESCRIPTION = "The SHR DBus API Specification"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ebef999b5d8aea38d9eb30772557f175"

DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "04394bad2ee838a9e5cc2035571f25e7d02772d8"
PV = "2011.03.08.2+gitr${SRCPV}"

SRC_URI = "git://git.shr-project.org/repo/shr-specs.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/shr-specs"


