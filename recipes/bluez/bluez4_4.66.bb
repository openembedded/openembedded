require bluez4.inc

SRC_URI[md5sum] = "3c82575778d5dcdd68ea961626b02109"
SRC_URI[sha256sum] = "c223cbb80df0b1f17f6ef4efd0be1fe35ae640bd979f852cfbcc452abc0a7ea5"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"
EXTRA_OECONF += "${BTUDEV}"
