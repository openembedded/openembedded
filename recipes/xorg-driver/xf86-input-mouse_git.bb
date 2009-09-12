require xorg-driver-input.inc
PE = "1"
PV = "1.4.0+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "X.Org X server -- mouse input driver"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-input-mouse;protocol=git;branch=master"

S = "${WORKDIR}/git"
