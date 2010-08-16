require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6092cdb0a1225f95356ddbe6c2abaad5"
SRC_URI[archive.sha256sum] = "7000005ebbd07a28a71477d72bcb76c47064e043a4ead26fcf4d5af394ce19df"

BBCLASSEXTEND = "native nativesdk sdk"
