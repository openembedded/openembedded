require xorg-proto-common.inc

DESCRIPTION = "Touchscreen calibration protocol"

PR = "r0"
PV = "0.0+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/proto/calibrateproto;protocol=git"
S = "${WORKDIR}/git"
