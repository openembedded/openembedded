SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPLv2+"
DEPENDS = "popt glib-2.0 gnome-vfs"

SRC_URI = "http://freedesktop.org/software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "dcace3294470e9cdc9ebfe7de1881ece"
SRC_URI[sha256sum] = "37245e1c606bbdbffa12d43e902a95d7081673191dc1246640c00cb5a8b4f4d2"
