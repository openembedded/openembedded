require xorg-app-common.inc
DESCRIPTION = "X display manager"
DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau libxext libxdmcp libxt libxaw"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a2b4c280f3e324d081a0d9ed76a8a123"
SRC_URI[archive.sha256sum] = "928238ea20e074372659b2902de0e0d754083196911319319795fdbfd1ca6073"

EXTRA_OECONF += " --with-random-device=/dev/urandom"
