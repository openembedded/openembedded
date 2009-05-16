# Doesn't build for everyone, errors range from missing includes to linking errors
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

require mtd-utils_${PV}.bb
require mtd-utils-native.inc
DEPENDS += "e2fsprogs-libs-native"
