DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebef999b5d8aea38d9eb30772557f175"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "b65c7700758a35225168116a50d6ebe9221f7c3a"
PV = "2011.05.18.1+gitr${SRCPV}"
PE = "1"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"
