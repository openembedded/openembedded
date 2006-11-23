#This is a development snapshot, so lets hint OE to use the releases
DEFAULT_PREFERENCE = "-1"

SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libsm libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"

SRC_URI = "http://cairographics.org/snapshots/cairo-${PV}.tar.gz \
           file://configure.in_requires_pkg-config-0.15.diff;patch=1;pnum=2"

inherit autotools pkgconfig 

do_stage () {
 	autotools_stage_all
}
