require xorg-app-common.inc
DESCRIPTION = "converts BDF fonts to PCF fonts"
DEPENDS += " libxfont"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "9685fab33d39954ab8a0d22e0969d5a4"
SRC_URI[archive.sha256sum] = "aaaa45ab361781aebda2093fdc7eb5c187f6215b4ba308dd6b9ff2b727e805d3"

BBCLASSEXTEND = "native"
