DESCRIPTION = "Utilities for Ben's Own Graphics Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "gd-native"
PR = "2"

SRC_URI = "${DEBIAN_MIRROR}/main/b/bogl/bogl_${PV}-${PR}.tar.gz"
S = "${WORKDIR}/bogl"

inherit native

do_compile() {
	oe_runmake bdftobogl pngtobogl
	# giftobogl doesn't work because gd no longer comes with GIF support
}

do_stage() {
	install -d ${STAGING_BINDIR}/
	install -m 0755 bdftobogl pngtobogl ${STAGING_BINDIR}/
}
