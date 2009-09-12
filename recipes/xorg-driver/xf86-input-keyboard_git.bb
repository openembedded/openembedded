require xorg-driver-input.inc
PE = "1"
PV = "1.3.2+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "X.Org X server -- keyboard input driver"

DEPENDS += " kbproto"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-input-keyboard;protocol=git;branch=master"

S = "${WORKDIR}/git"
