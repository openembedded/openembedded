#This is a development snapshot, so lets hint OE to use the releases
#DEFAULT_PREFERENCE = "-1"

SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libsm libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"

PV = "1.3.2+git${SRCDATE}"

SRC_URI = "git://git.cairographics.org/git/cairo;protocol=git \
	  "
inherit autotools pkgconfig 

S = "${WORKDIR}/git"

do_configure_prepend() {
	sed -i s:PKGCONFIG_REQUIRED=0.19:PKGCONFIG_REQUIRED=0.15: configure.in
}

do_stage () {
 	autotools_stage_all
}
