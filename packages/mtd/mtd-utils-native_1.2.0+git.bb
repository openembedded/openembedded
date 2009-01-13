# Needs testing
DEFAULT_PREFERENCE = "-1"

require mtd-utils_${PV}.bb
require mtd-utils-native.inc
DEPENDS += "e2fsprogs-libs-native"
