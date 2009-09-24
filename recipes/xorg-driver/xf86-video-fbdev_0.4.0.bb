require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- fbdev display driver"

FILES_${PN} += " file://use-staged-headers.patch;patch=1"

#DEPENDS += " "
