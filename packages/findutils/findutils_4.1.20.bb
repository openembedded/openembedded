SECTION = "console/utils"
LICENSE = "GPL"
DESCRIPTION = "find, locate, and xargs binaries."
PR = "r1"

SRC_URI = "ftp://alpha.gnu.org/gnu/findutils/findutils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://make.patch;patch=1"

inherit autotools gettext
