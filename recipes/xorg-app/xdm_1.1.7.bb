require xorg-app-common.inc
PE = "1"

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt libxaw"

EXTRA_OECONF += " --with-random-device=/dev/urandom"

FILES_${PN}-dbg += "${libdir}/X11/xdm/.debug/*"

SRC_URI[archive.md5sum] = "92effdb698d9ecc9113fe4f49294bd90"
SRC_URI[archive.sha256sum] = "6a7bceccb1eb9ce3d14259be7a6cc8268bc9e1f127298480b9322ceb6f032d6d"
