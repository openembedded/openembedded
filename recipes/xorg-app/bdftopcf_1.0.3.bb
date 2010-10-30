require xorg-app-common.inc
DESCRIPTION = "converts BDF fonts to PCF fonts"
DEPENDS += " libxfont"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4a7a4a848c43c42f7d499b60666434a4"
SRC_URI[archive.sha256sum] = "9c90b408b2fe079495697bfc8fb13da940b2b70f4907213bf5dcc9e3024a1d0a"

BBCLASSEXTEND = "native"
