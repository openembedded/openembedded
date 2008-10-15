SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PR = "r4"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz \
           file://pixman-arm.patch;patch=1 \
	   file://pixman-x888-565.patch;patch=1 \
	  "

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage () {
 	autotools_stage_all
}

