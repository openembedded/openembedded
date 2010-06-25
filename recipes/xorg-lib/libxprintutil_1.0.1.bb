require xorg-lib-common.inc
DESCRIPTION = "Xprint printer utility client library"
DEPENDS += "libxp libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "22584f1aab1deba253949b562d1f0f45"
SRC_URI[archive.sha256sum] = "72b6ae0420b9601f55be147e8d068f670b951ae73a81423ba25be5875d826e6c"

XORG_PN = "libXprintUtil"
