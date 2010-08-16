require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "2ed80e90992e7455eaac4c3e977ebd01"
SRC_URI[archive.sha256sum] = "6d659920262d41e48714184f94ff9cd2608515e0f3d2f074892fe0c048784df4"

BBCLASSEXTEND = "native nativesdk sdk"
