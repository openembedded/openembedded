require gtk+_${PV}.bb

FILESPATH_prepend = "${FILE_DIRNAME}/gtk+-${PV}:"

DEFAULT_PREFERENCE = "-1"

PROVIDES = "gtk+"
RPROVIDES_${PN} = "gtk+"
PR = "r2"

SRC_URI += "file://lower-quality-scaling-in-pixbuf-engine.patch;patch=1"

S = "${WORKDIR}/gtk+-${PV}"

