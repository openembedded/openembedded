require xorg-data-common.inc

DESCRIPTION = "Common X11 Bitmaps"
LICENSE = "MIT"
DEPENDS += "libxmu"


SRC_URI[archive.md5sum] = "7444bbbd999b53bec6a60608a5301f4c"
SRC_URI[archive.sha256sum] = "3671b034356bbc4d32d052808cf646c940ec8b2d1913adac51b1453e41aa1e9d"
PR = "${INC_PR}.0"
