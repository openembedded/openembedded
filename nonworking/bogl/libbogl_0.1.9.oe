DESCRIPTION = "Ben's Own Graphics Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "bogl-utils-native"
PR = "2"

SRC_URI = "${DEBIAN_MIRROR}/main/b/bogl/bogl_${PV}-${PR}.tar.gz"
S = "${WORKDIR}/bogl"

do_compile() {
	ln -sf ${STAGING_BINDIR}/bdftobogl .
	ln -sf ${STAGING_BINDIR}/pngtobogl .
	oe_runmake libbogl.so.0.1 libbogl.a
}

do_stage() {
	oe_soinstall libbogl.so.0.1 ${STAGING_LIBDIR}/
	install bogl*.h ${STAGING_INCDIR}/
}

do_install() {
	oe_soinstall libbogl.so.0.1 ${STAGING_LIBDIR}/
}

