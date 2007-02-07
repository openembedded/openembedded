require kanjipad.inc

SECTION = "libs"

SRC_URI += "file://Makefile-kpengine-only.patch;patch=1"

FILES = "${bindir}/kpengine ${datadir}"

# would it be better to make this a part of kanjipad bb?
S = ${WORKDIR}/kanjipad-2.0.0/
