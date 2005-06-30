SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"
DEPENDS = "popt glib-2.0 gnome-vfs"

SRC_URI = "http://freedesktop.org/Software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz"

inherit autotools 
