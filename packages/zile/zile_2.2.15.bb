DESCRIPTION = "Zile is lossy Emacs."
HOMEPAGE = "http://zile.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "ncurses"
SECTION = "console/editors"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/zile/zile-${PV}.tar.gz"

inherit autotools
