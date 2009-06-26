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
