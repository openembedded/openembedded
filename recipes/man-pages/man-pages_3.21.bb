SECTION = "base"
DESCRIPTION = "base set of man pages"
LICENSE = "GPL"
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/docs/man-pages/Archive/man-pages-${PV}.tar.bz2"
PR = "r1"
RRECOMMENDS = "man"
PACKAGE_ARCH = "all"

EXTRA_OEMAKE = ""
do_compile () {
	:
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

FILES_${PN} = "*"
FILES_${PN}-doc = ""

SRC_URI[md5sum] = "14b3f971348f4d59ae8b8362d8eb15ff"
SRC_URI[sha256sum] = "272ac90813e4301873d46229b216622bb7bc6a0b3adb15577b20b5083f92a169"
