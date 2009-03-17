DESCRIPTION = "Zile is lossy Emacs."
HOMEPAGE = "http://ftp.gnome.org/pub/gnome/sources/zenity/"
LICENSE = "GPL"
DEPENDS = "libgnomecanvas"
SECTION = "console/utils"

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/zenity/2.20/zenity-${PV}.tar.bz2 \
	    file://makefile.patch;patch=1"

inherit autotools
