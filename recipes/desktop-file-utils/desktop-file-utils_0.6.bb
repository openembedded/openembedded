SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"
DEPENDS = "popt glib-2.0 gnome-vfs"

SRC_URI = "http://freedesktop.org/Software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "0d6b6d4fa861f73e0b4225e93077578f"
SRC_URI[sha256sum] = "64c05a48e91850627cfaa7314d4b4b847547bc4333fa9345994fa49c79276f3d"
