require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a49416013fff33c853efb32f1926551e"
SRC_URI[archive.sha256sum] = "cfeb1429465e3c24debde1bf53ec35ef738fde5e80d2eed14f33e315e747bb8d"

BBCLASSEXTEND = "nativesdk sdk"

CONFLICTS = "randrext"
