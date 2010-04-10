require xorg-app-common.inc
PE = "1"

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt libxaw"

EXTRA_OECONF += " --with-random-device=/dev/urandom"

SRC_URI[archive.md5sum] = "a2b4c280f3e324d081a0d9ed76a8a123"
SRC_URI[archive.sha256sum] = "928238ea20e074372659b2902de0e0d754083196911319319795fdbfd1ca6073"
