require xorg-app-common.inc

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt"

EXTRA_OECONF += " --with-random-device=/dev/urandom"
