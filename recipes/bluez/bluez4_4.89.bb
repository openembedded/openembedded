require bluez4.inc

SRC_URI[md5sum] = "67fd9ad2852ce01f01b16ddd2336d1ea"
SRC_URI[sha256sum] = "922e1a9c894c8667fc92f536c26553e8f094a676e96fb409bc384dd70f5ddde7"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"

EXTRA_OECONF += "${BTUDEV}"
