require xorg-app-common.inc
DESCRIPTION = "X authority file utility"
DEPENDS += "libxau libxext libxmu"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "46fc44e5e947d3720f3be5054044ff0e"
SRC_URI[archive.sha256sum] = "6d139500ff1daf806525adf071f8c1778ad138a0378c73ea831ad18847ad746c"
