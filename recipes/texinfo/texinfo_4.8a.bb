DESCRIPTION = "Documentation system for on-line information and printed output"
HOMEPAGE = "http://www.gnu.org/software/texinfo/"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"

SRC_URI = "${GNU_MIRROR}/texinfo/texinfo-${PV}.tar.bz2"

inherit autotools gettext

S = "${WORKDIR}/texinfo-4.8/"
