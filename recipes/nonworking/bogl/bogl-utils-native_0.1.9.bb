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

SRC_URI[md5sum] = "644c4bc8d45b3be8132f120fd89bf72a"
SRC_URI[sha256sum] = "a18326be2b52f0aa062afc697e22cc639ac3a8f5cee35cb0c1dfcbf638196144"
