require python-efl.inc
DEPENDS += "edje python-evas eina"
RDEPENDS += "python-evas"
PV = "0.3.0+svnr${SRCREV}"
PR = "r0"

SRC_URI += "file://0001-fix-unicode-conversion.patch;patch=1"
