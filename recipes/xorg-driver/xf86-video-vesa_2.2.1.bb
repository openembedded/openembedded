require xorg-driver-video.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://fix-includepath.patch \
            file://fix-configure-includes.patch"
SRC_URI[archive.md5sum] = "61a1dc9a22991bd04d0ff98f800775c1"
SRC_URI[archive.sha256sum] = "a3657971232e9c7db3e7517a8aedd86d3ef4d159f7099ec974cdd03aafa41080"
