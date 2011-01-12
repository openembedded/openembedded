require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS_${PN} += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
             xserver-xorg-extension-glx"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "05f187582aeabda57fcd6f2782cfbf8e"
SRC_URI[archive.sha256sum] = "e18c37a579a960516e69de5c6f74750ca02208c0e41cf763ae5630c84db507df"
