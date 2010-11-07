require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- evdev input driver"
PE = "1"
PV = "2.5.0+gitr${SRCPV}"
PR = "${INC_PR}.0"
DEFAULT_PREFERENCE = "-1"

SRCREV = "a4aefca2ed52e675e6151a0fb0742a9e19565a41"
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/${PN};protocol=git;branch=master"
S = "${WORKDIR}/git"
