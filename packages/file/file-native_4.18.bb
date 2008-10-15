require file_${PV}.bb
inherit native

# avoid dependency loop
DEPENDS = ""
FILE_PR = "r1"

SRC_URI += "file://native-fix.diff;patch=1"
