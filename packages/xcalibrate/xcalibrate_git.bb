PV = "0.0+git${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 xcalibrateext libxext"
DESCRIPTION = "XCalibrate client-side library"

SRC_URI = "git://anongit.freedesktop.org/xorg/lib/libXCalibrate;protocol=git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
