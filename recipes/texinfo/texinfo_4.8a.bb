DESCRIPTION = "Documentation system for on-line information and printed output"
HOMEPAGE = "http://www.gnu.org/software/texinfo/"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"

SRC_URI = "${GNU_MIRROR}/texinfo/texinfo-${PV}.tar.bz2"

inherit autotools gettext

S = "${WORKDIR}/texinfo-4.8/"

SRC_URI[md5sum] = "0f429f87de9f20d6c0d952e63bf8e3fa"
SRC_URI[sha256sum] = "efcda677be7ef093757d965736dff3b5af8c9fd36b3e7d3db09289a4a1d5d013"
