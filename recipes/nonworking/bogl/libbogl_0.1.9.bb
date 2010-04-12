DESCRIPTION = "Ben's Own Graphics Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "bogl-utils-native"
PR = "2"

SRC_URI = "${DEBIAN_MIRROR}/main/b/bogl/bogl_${PV}-${PR}.tar.gz"
S = "${WORKDIR}/bogl"

do_compile() {
ln -sf ${STAGING_BINDIR_NATIVE}/bdftobogl .
ln -sf ${STAGING_BINDIR_NATIVE}/pngtobogl .
oe_runmake libbogl.so.0.1 libbogl.a
}

do_stage() {
oe_soinstall libbogl.so.0.1 ${STAGING_LIBDIR}/
install bogl*.h ${STAGING_INCDIR}/
}

do_install() {
oe_soinstall libbogl.so.0.1 ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "644c4bc8d45b3be8132f120fd89bf72a"
SRC_URI[sha256sum] = "a18326be2b52f0aa062afc697e22cc639ac3a8f5cee35cb0c1dfcbf638196144"
