require xorg-lib-common.inc
DESCRIPTION = "Touchscreen calibration client library"
LICENSE = "BSD-X"
DEPENDS = "virtual/libx11 calibrateproto libxext"
PE = "3"
PV = "0.0+${PR}+gitr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libXCalibrate;protocol=git"

SRCREV = "209d83af61ed38a002c8096377deac292b3e396c"
S = "${WORKDIR}/git"

FILES_${PN}-locale += "${datadir}/X11/locale"
