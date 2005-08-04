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
