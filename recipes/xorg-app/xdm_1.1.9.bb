require xorg-app-common.inc
PE = "1"
PR = "r1"

DESCRIPTION = "X display manager"

DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau virtual/libx11 libxext libxdmcp libxt libxaw"

EXTRA_OECONF += "\
	--with-random-device=/dev/urandom --with-utmp-file=/var/run/utmp \
	--with-wtmp-file=/var/log/wtmp \
	"

FILES_${PN}-dbg += "${libdir}/X11/xdm/.debug/*"

SRC_URI[archive.md5sum] = "030ae4bd9b8d428749d68bfdf56ce8a5"
SRC_URI[archive.sha256sum] = "e7b1db0e1b0d0113a301d94e40b0314e55f7e0006415f50a9cf06f636b11b134"
