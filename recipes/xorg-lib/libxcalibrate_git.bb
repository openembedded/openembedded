require xorg-lib-common.inc

DESCRIPTION = "	Touchscreen calibration client library"
LICENSE = "BSD-X"
DEPENDS = "virtual/libx11 calibrateproto libxext"
PV = "0.0+gitr${SRCPV}"
PE = "2"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libXCalibrate;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN}-locale += "${datadir}/X11/locale"
