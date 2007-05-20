PV = "0.0+git${SRCDATE}"
SECTION = "x11/libs"
LICENSE = "BSD-X"
DESCRIPTION = "XCalibrate extension headers"

PR = "r1"

SRC_URI = "git://anongit.freedesktop.org/xorg/proto/calibrateproto;protocol=git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
	#make it compatible with the old package from cvs
	ln -sf ${PKG_CONFIG_PATH}/xcalibrateproto.pc ${PKG_CONFIG_PATH}/xcalibrateext.pc
}
