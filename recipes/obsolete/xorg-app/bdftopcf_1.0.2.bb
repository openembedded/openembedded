require xorg-app-common.inc
DESCRIPTION = "converts BDF fonts to PCF fonts"
DEPENDS += " libxfont"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "148f20d28caaa69bbe7dcca7c2674fb6"
SRC_URI[archive.sha256sum] = "11017f0dd637fd3228bd56fdbbd72193fd747c10d893a711c25bf6734c4da06b"

BBCLASSEXTEND = "native"
