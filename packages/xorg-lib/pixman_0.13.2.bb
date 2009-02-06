SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz \
           file://pixman-0.13.2-neon1.patch;patch=1 \
	  "

inherit autotools

# We have NEON
EXTRA_OECONF_append_armv7a = " --disable-arm-simd"

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage () {
 	autotools_stage_all
}

