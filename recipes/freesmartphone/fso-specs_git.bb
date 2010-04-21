DESCRIPTIONS = "freesmartphone.org DBus API files"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "BSD"
DEPENDS = "libxslt-native"
SECTION = "devel/specifications"
SRCREV = "27b29f8ebd15ec05ebcca19f4aaa476ecd54aa80"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"
PR = "r2"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dev += "${datadir}/freesmartphone/xml"
PACKAGE_ARCH = "all"

do_compile_append() {
	sed -i -e s,\$\{datarootdir\},${STAGING_DATADIR},g *.pc
}
