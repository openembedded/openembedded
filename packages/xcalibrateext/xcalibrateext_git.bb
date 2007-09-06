SECTION = "x11/libs"
LICENSE = "BSD-X"
DESCRIPTION = "XCalibrate extension headers"

PV = "0.0+gita1d5ef0c73fbef3e758c51b57ac69ba9567bae04"
PR = "r1"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/proto/calibrateproto;protocol=git;tag=a1d5ef0c73fbef3e758c51b57ac69ba9567bae04"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
	#make it compatible with the old package from cvs
	ln -sf ${PKG_CONFIG_DIR}/xcalibrateproto.pc ${PKG_CONFIG_DIR}/xcalibrateext.pc
}
