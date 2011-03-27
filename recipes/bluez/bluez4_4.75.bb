require bluez4.inc

SRC_URI[md5sum] = "ee95086aef5955b25f1226b9e45bd6be"
SRC_URI[sha256sum] = "fd861de5c966dc563e6a1c34400bb0c0fe1277e37655ab3ce3f48356035f61b8"

DEFAULT_PREFERENCE = "-1"

DEPENDS += "libnl libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"
EXTRA_OECONF += "${BTUDEV}"
