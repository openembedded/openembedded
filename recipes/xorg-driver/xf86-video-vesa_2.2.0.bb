require xorg-driver-video.inc
PE = "1"

SRC_URI += "file://fix-includepath.patch \
            file://fix-configure-includes.patch"

#DESCRIPTION = ""

RDEPENDS_${PN} += "xserver-xorg-module-libint10 "
PR = "r3"
SRC_URI[archive.md5sum] = "9a86b683f73f3806f55d05cd804a6f4a"
SRC_URI[archive.sha256sum] = "8b3e077d2534722033d7b1c647aa7f31fc7fbb5014da096b7a53170005e80226"
