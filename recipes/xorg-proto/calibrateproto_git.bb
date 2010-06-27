require xorg-proto-common.inc
DESCRIPTION = "Touchscreen calibration protocol"
PE = "3"
PV = "0.0+${PR}+gitr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/proto/calibrateproto;protocol=git"

SRCREV = "1da6fd1e2c7a49648245c98481fabea8b9690a8c"
S = "${WORKDIR}/git"

do_stage() {
        autotools_stage_all
        #make it compatible with the old package from cvs
        ln -sf ${PKG_CONFIG_DIR}/xcalibrateproto.pc ${PKG_CONFIG_DIR}/xcalibrateext.pc
}
