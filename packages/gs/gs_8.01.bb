DESCRIPTION = "An interpreter of the Postscript language"
LICENSE = GPL
SECTION = "console/utils"
SRC_URI = "ftp://ftp.gnu.org/gnu/ghostscript/gnughostscript-${PV}.tar.gz"
DEPENDS = "jpeg zlib"
PR = "r2"

# | make: ./obj/echogs: Command not found
BROKEN = 1

S = "${WORKDIR}/gnughostscript-${PV}"

FILES_${PN} += "${datadir}/ghostscript"

inherit autotools flow-lossage

EXTRA_OECONF = "--without-x"

do_compile() {
	oe_runmake CCAUX="${BUILD_CC}"
}

do_install() {
	oe_runmake bindir='${D}${bindir}' datadir='${D}${datadir}' libdir='${D}${libdir}' install
}
