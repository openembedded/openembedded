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


SRC_URI[md5sum] = "d3912b9f7bf745fbfea68f6a9b9de30f"
SRC_URI[sha256sum] = "133caca2c4e7c64106555154ee0ff693f5cf5beb9421ce2eb86baee997d22368"
