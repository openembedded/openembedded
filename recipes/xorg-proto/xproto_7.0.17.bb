require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "74abb8fb91af66f35873b1f444731220"
SRC_URI[archive.sha256sum] = "9b2c1fdc5b3780cedc9f5d9caf8f1364f26d07f8502b0eccdde74319157f9d01"

BBCLASSEXTEND = "native nativesdk sdk"
