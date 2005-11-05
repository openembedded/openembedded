SECTION = "base"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/cramfs/cramfs-1.1.tar.gz"
DEPENDS = "zlib-native"

S = "${WORKDIR}/cramfs-${PV}"

inherit native

do_compile() {
	oe_runmake
}

do_stage() {
	install mkcramfs ${STAGING_BINDIR}
	install cramfsck ${STAGING_BINDIR}
}

