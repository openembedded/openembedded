require gtk+_${PV}.bb

FILESPATH_prepend = "${FILE_DIRNAME}/gtk+-${PV}:"

DEFAULT_PREFERENCE = "-1"

PROVIDES = "gtk+"
RPROVIDES_${PN} = "gtk+"
PR = "r2"

SRC_URI += "file://lower-quality-scaling-in-pixbuf-engine.patch;patch=1"

S = "${WORKDIR}/gtk+-${PV}"


SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"
