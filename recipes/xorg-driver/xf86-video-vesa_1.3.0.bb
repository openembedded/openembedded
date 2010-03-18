require xorg-driver-video.inc
PE = "1"

SRC_URI += "file://fix-includepath.patch;patch=1"

#DESCRIPTION = ""

#DEPENDS += " "
SRC_URI[archive.md5sum] = "4a307852f3b4850e436a41dab2a73676"
SRC_URI[archive.sha256sum] = "b96c80ae81f5123ecef344dac4c734b2e281143d3ab7a7e633d6bf04c893e203"
