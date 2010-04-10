DESCRIPTION = "An interpreter of the Postscript language"
LICENSE = "GPL"
SECTION = "console/utils"
HOMEPAGE = "http://www.gnu.org/software/ghostscript/ghostscript.html"
DEPENDS = "jpeg zlib"
PR = "r0"

SRC_URI = "${GNU_MIRROR}/ghostscript/gnu-ghostscript-${PV}.tar.gz"
S = "${WORKDIR}/gnu-ghostscript-${PV}"

inherit autotools flow-lossage

EXTRA_OECONF = "--without-x"

do_configure() {
	gnu-configize
	oe_runconf
}

do_compile() {
	oe_runmake CCAUX="${BUILD_CC}"
}

do_install() {
	oe_runmake bindir='${D}${bindir}' datadir='${D}${datadir}' libdir='${D}${libdir}' install
}

FILES_${PN} += "${datadir}/ghostscript"

SRC_URI[md5sum] = "c42dfaebc37fe81eab0b5676b124ab63"
SRC_URI[sha256sum] = "417922d35e66ee90cf93cf3e93fdf281ec6b92de4f7436c9c1a97c0cc35b94a8"
