DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebef999b5d8aea38d9eb30772557f175"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "68842741f6041d51e4b89dee0a79f62d90cdb2b2"
PV = "2011.03.15.1+gitr${SRCPV}"
PE = "1"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"
