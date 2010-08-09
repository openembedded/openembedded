require xorg-proto-common.inc
DESCRIPTION = "Touchscreen calibration protocol"
PE = "3"
PV = "0.0+${PR}+gitr${SRCPV}"
PR = "${INC_PR}.1"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/proto/calibrateproto;protocol=git"

SRCREV = "1da6fd1e2c7a49648245c98481fabea8b9690a8c"
S = "${WORKDIR}/git"

do_install_append() {
        #make it compatible with the old package from cvs
        ln -sf xcalibrateproto.pc ${D}${libdir}/pkgconfig/xcalibrateext.pc
}
