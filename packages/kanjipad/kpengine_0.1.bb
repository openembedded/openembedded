require kanjipad.inc

DESCRIPTION = "Japanese HWR engine used by a number of programs. Original algorithms by Todd Ruddick."
SECTION = "inputmethods"
PR = "r1"

SRC_URI += "file://Makefile-kpengine-only.patch;patch=1"

FILES_${PN} = "${bindir}/kpengine ${datadir}"
