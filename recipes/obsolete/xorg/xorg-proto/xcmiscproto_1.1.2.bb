require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "fde0b050901f024b19159cdacdcfbd20"
SRC_URI[archive.sha256sum] = "b2807e96a9d632b7bbf1782a43095de51f3feae3d2e25374d3df00c6c68792ab"

BBCLASSEXTEND = "native nativesdk sdk"
