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


SRC_URI[md5sum] = "92ea2e86a5489f0d16567920f2ec9b36"
SRC_URI[sha256sum] = "24c8ce0626edb9ef8799a95ecfc252635842038242fba8fe90301f1e0eabfb8b"
