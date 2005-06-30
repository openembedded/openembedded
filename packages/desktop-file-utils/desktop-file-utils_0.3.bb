SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"
DEPENDS = "popt glib-2.0"

SRC_URI = "http://freedesktop.org/Software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools 
