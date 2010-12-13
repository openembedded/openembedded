DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "384df6677e076e742303a485d9f0b68ee9336a7e"
PV = "2010.10.15.1+gitr${SRCPV}"
PE = "1"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"
