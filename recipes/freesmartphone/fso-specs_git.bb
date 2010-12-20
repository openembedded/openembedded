DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "6cfab386f756ef1e20e2a3da958c32bc21fd7607"
PV = "2010.12.13.1+gitr${SRCPV}"
PE = "1"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"
