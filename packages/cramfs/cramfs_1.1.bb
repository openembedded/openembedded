DESCRIPTION="Builds cramfs filesystems for embedded systems"
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/cramfs/cramfs-1.1.tar.gz \
	file://makefile.patch;patch=1 \
	file://cramfs-andersee.patch;patch=1"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install mkcramfs ${D}${bindir}
	install cramfsck ${D}${bindir}
}

