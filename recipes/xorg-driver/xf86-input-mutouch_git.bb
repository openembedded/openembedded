require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- muTouch input driver"
PE = "1"
PR = "${INC_PR}.0"
SRCREV = "db04a5333b545a0442b995bae47d2c5527a7459e"
PV = "1.2.1+gitr${SRCREV}"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-input-mutouch;protocol=git"

S = "${WORKDIR}/git"
