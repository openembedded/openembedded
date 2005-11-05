SECTION = "base"
SRC_URI = "${SOURCEFORGE_MIRROR}/cramfs/cramfs-1.1.tar.gz"
LICENSE = "GPLv2"
DEPENDS = "zlib"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install mkcramfs ${D}${bindir}
	install cramfsck ${D}${bindir}
}

