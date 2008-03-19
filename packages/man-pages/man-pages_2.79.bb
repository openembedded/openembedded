SECTION = "base"
DESCRIPTION = "base set of man pages."
LICENSE = "GPL"
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/docs/man-pages/Archive/man-pages-${PV}.tar.bz2"

EXTRA_OEMAKE = ""
do_compile () {
	:
}

do_install () {
	oe_runmake 'prefix=${D}' install
}

FILES_${PN} = "*"
