require xorg-app-common.inc
DESCRIPTION = "adjust backlight brightness using RandR extension"
DEPENDS += " libxrender libxrandr"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "c9891d6a3f3129d56cede72daa0ba26c"
SRC_URI[archive.sha256sum] = "af2f02d09de8a19848e3f3b322320141bceebf9d4097b7bd505457a1bd936509"
