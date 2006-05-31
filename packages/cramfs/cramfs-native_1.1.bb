FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/cramfs"

DESCRIPTION="Builds cramfs filesystems for embedded systems"
SECTION = "base"
LICENSE="GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/cramfs/cramfs-1.1.tar.gz \
	file://makefile.patch;patch=1 \
	file://cramfs-andersee.patch;patch=1"

DEPENDS = "zlib-native"

S = "${WORKDIR}/cramfs-${PV}"

inherit native

do_compile() {
	oe_runmake all
}

do_stage() {
	install -m 755 mkcramfs ${STAGING_BINDIR}
	install -m 755 cramfsck ${STAGING_BINDIR}
}

