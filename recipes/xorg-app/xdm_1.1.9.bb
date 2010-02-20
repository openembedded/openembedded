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
