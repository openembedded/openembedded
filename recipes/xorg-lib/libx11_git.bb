require libx11.inc
PV = "1.3.3+git"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libX11;protocol=git"
SRC_URI += " file://keysymdef_include.patch \
             file://x11_disable_makekeys.patch \
             file://dolt-fix.patch \
"

SRCREV = "c3f3e4a9e531d010312c97e753d6e543e607094d"
S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "-1"
