SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz \
	  "

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

