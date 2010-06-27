require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "242388ab65dde3a3dd313eeee265e429"
SRC_URI[archive.sha256sum] = "53f3039ae769b08bd139d4474a7debe0b6f24048e7c514c835c8a1880f11e0d9"

BBCLASSEXTEND = "native nativesdk sdk"
