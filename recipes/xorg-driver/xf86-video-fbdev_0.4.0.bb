require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- fbdev display driver"

FILES_${PN} += " file://use-staged-headers.patch;patch=1"

#DEPENDS += " "
SRC_URI[archive.md5sum] = "6572b39fec77b8e6de1c858a93992924"
SRC_URI[archive.sha256sum] = "bba725daeb2a313b83f2b92855a9ae8aa72c4cc8581f9f62f101ebdf00ac359d"
