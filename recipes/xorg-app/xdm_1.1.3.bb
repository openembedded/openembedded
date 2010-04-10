require xorg-app-common.inc
PE = "1"

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt libxaw"

EXTRA_OECONF += " --with-random-device=/dev/urandom"

SRC_URI[archive.md5sum] = "619d0549c6c20ca15aa77769f2fbabe2"
SRC_URI[archive.sha256sum] = "9e640974c132ef1faafedc77e4602d55457b2791006b677cec071ee8afbf9a74"
