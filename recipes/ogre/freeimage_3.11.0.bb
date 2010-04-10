LICENSE = "MIT"
do_unpack[depends] += "unzip-native:do_populate_staging"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freeimage/FreeImage3110.zip"

S = "${WORKDIR}/FreeImage/"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.gnu
}

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${includedir}
	oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" install
}


SRC_URI[md5sum] = "ad1db36414391417654ba7bf1c0277d3"
SRC_URI[sha256sum] = "84021b8c0b86e5801479474ad9a99c18d121508ee16d363e02ddcbf24195340c"
