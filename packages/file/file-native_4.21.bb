require file_${PV}.bb
inherit native
DEPENDS = "zlib-native"
FILE_PR = "r0"

SRC_URI += "file://native-fix.diff;patch=1"
