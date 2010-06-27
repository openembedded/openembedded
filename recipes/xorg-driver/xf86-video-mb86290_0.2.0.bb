require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- MB8629x (Coral-P/PA, Carmine) display driver"
PE = "1"

SRC_URI = "http://kernel.org/~lumag/mb86290/${BPN}-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "2ccde06fc912305fb03666592652e1f9"
SRC_URI[archive.sha256sum] = "04ea5c10186873c6d53dafcdbbfe273e114f6e26b0f76529449384392c190f92"
