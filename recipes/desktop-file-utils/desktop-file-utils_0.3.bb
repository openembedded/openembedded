SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPLv2+"
DEPENDS = "popt glib-2.0"

SRC_URI = "http://freedesktop.org/software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz \
	   file://m4.patch"

inherit autotools

SRC_URI[md5sum] = "a1c8bcd648da58bfe0b142042292caa8"
SRC_URI[sha256sum] = "06a3d9d97dce9773fc8ac47d6c01aa5e0c0c517cb6ac2e06a627479a0593efca"
