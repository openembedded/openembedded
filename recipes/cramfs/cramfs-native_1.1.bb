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


SRC_URI[md5sum] = "d3912b9f7bf745fbfea68f6a9b9de30f"
SRC_URI[sha256sum] = "133caca2c4e7c64106555154ee0ff693f5cf5beb9421ce2eb86baee997d22368"
