require xorg-lib-common.inc

DESCRIPTION = "Touchscreen calibration client library"
LICENSE = "BSD-X"
DEPENDS = "virtual/libx11 calibrateproto libxext"

PR = "r0"
PV = "0.0+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libXCalibrate;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN}-locale += "${datadir}/X11/locale"
