DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "f5df109924f964095e184d26796070343c3bb6da"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"
PR = "r3"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"

do_compile_append() {
	sed -i -e s,\$\{datarootdir\},${STAGING_DATADIR},g *.pc
}
