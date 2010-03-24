DESCRIPTION = "fileschanged is a GNU/Linux command-line utility that reports when files have been altered"
LICENSE = "GPL"
DEPENDS = "gamin"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/fileschanged/fileschanged-${PV}.tar.gz;name=fileschanged-${PV} \
	file://fileschanged-no-man-build.patch;patch=1 \
	"

inherit autotools
