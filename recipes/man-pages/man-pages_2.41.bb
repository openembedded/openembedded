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

SRC_URI[md5sum] = "7b193c2fcf1d8f625e998df54582fee9"
SRC_URI[sha256sum] = "bc9e3fe06a550d6eb48fd84eaf58415c78fbc29ba042e4a074adb62736f50760"
