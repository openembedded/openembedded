DESCRIPTION = "libgpod - a library to access the Apple iPod"
HOMEPAGE = "http://www.gtkpod.org/libgpod.html"
LICENSE = "LGPL"
DEPENDS = "glib-2.0"
SECTION = "libs/multimedia"
PR = "r0"

inherit autotools

SRC_URI = "http://kent.dl.sourceforge.net/sourceforge/gtkpod/libgpod-${PV}.tar.gz"

do_stage() {
	autotools_stage_all
}

