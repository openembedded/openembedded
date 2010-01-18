require bluez4-libs.inc

PR = "${INC_PR}"

SRC_URI += "file://avinfo-link.patch;patch=1;pnum=0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"
