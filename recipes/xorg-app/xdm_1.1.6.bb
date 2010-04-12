require xorg-app-common.inc
PE = "1"

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt libxaw"

EXTRA_OECONF += " --with-random-device=/dev/urandom"

FILES_${PN}-dbg += "${libdir}/X11/xdm/.debug/*"

SRC_URI[archive.md5sum] = "c89f8bc74fda4d19e5f374f59c88810f"
SRC_URI[archive.sha256sum] = "c41ac89d9da5c3f5424e9c4871d363ff17acf0fd2a46830931c447ba0b5a8bcd"
