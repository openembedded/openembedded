SECTION = "base"
DESCRIPTION = "base set of man pages."
LICENSE = "GPL"
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/docs/manpages/man-pages-${PV}.tar.bz2"

EXTRA_OEMAKE = ""
do_compile () {
	:
}

do_install () {
	oe_runmake 'prefix=${D}' install
}

PACKAGES = "${PN}"
FILES_${PN} = "*"
