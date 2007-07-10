require file_${PV}.bb
inherit native

# avoid dependency loop
DEPENDS = "zlib-native"
PR = "r2"

SRC_URI += "file://native-fix.diff;patch=1"
