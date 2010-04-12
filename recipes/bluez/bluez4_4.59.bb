require bluez4.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"
EXTRA_OECONF += "${BTUDEV}"


SRC_URI[md5sum] = "1c7cee215bc84656b1edee019cee78f5"
SRC_URI[sha256sum] = "c1f4496a1c23038fc7924d0b3eaf83c6dfb22611196e2d07d4a81efef8ca55e5"
