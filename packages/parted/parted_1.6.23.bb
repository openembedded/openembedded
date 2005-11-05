DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "console/tools"
DEPENDS = "readline e2fsprogs-libs"
PR = "r0"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz"

EXTRA_OECONF = "--disable-Werror"

inherit autotools
