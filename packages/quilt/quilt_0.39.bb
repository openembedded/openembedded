include quilt.inc

SRC_URI = "http://download.savannah.gnu.org/releases/quilt/quilt-${PV}.tar.gz \
	   file://install.patch;patch=1 \
	   file://nostrip.patch;patch=1"

inherit autotools gettext

include quilt-package.inc
