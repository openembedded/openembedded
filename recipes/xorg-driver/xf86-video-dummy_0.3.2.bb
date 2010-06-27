require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- dummy display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://get-rid-of-host-includes.patch"
SRC_URI[archive.md5sum] = "2a6f1f07462fbe336865068cd69c8593"
SRC_URI[archive.sha256sum] = "9389cbc21b0b5f90920fdfaad4466f4ec07674bb1ddbbf63cbb8759ace5c45fa"
