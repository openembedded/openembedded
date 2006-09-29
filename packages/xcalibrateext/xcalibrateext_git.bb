PV = "0.0+git${SRCDATE}"
SECTION = "x11/libs"
LICENSE = "BSD-X"
DESCRIPTION = "XCalibrate extension headers"

SRC_URI = "git://anongit.freedesktop.org/xorg/proto/calibrateproto;protocol=git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
