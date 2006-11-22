DESCRIPTION = "RefDbg is a GObject Reference Count Debugger"
HOMEPAGE = "http://refdbg.sourceforge.net/index.html"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "binutils"

SRC_URI = "${SOURCEFORGE_MIRROR}/refdbg/refdbg-${PV}.tar.gz"

inherit autotools

