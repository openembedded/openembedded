DESCRIPTION = "GNU cpio is a program to manage archives of files."
HOMEPAGE = "http://www.gnu.org/software/cpio/"
SECTION = "console"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/cpio/cpio-${PV}.tar.gz \
	   file://install.patch;patch=1"
S = "${WORKDIR}/cpio-${PV}"

inherit autotools
