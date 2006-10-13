DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "poppler gtk+"
PR="r2"

SRC_URI = "http://www.emma-soft.com/projects/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2"

inherit autotools

do_compile_append () {
	sed -i 's|\$.*prefix./|/usr/|' data/epdfview.desktop
}

