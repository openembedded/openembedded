LICENSE = "BSD-X"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 xcalibrateext libxext"
DESCRIPTION = "XCalibrate client-side library"

PV = "0.0+git4be232e30cd33a44a1ce6d3ec429ee6101540c62"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libXCalibrate;protocol=git;tag=4be232e30cd33a44a1ce6d3ec429ee6101540c62"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
