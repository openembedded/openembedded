require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "edje python-evas"
RDEPENDS += "python-evas"

SRC_URI += "file://0001-fix-unicode-conversion.patch;patch=1"
