require kanjipad.inc

DESCRIPTION = "Japanese HWR engine used by a number of programs. Original algorithms by Todd Ruddick."
SECTION = "inputmethods"
PR = "r1"

SRC_URI += "file://Makefile-kpengine-only.patch;patch=1"

FILES_${PN} = "${bindir}/kpengine ${datadir}"

SRC_URI[md5sum] = "bdfe75534322840b3ff566e0a91c472d"
SRC_URI[sha256sum] = "28272f61ec09c607a3578e3626e9e4fd43d1d9d1e21cb64328745766d00ee9e1"
