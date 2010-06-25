require libx11.inc

DEFAULT_PREFERENCE = "-1"
PV = "1.3.3+git"
SRCREV = "c3f3e4a9e531d010312c97e753d6e543e607094d"
SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libX11;protocol=git"
SRC_URI += " file://keysymdef_include.patch \
             file://x11_disable_makekeys.patch \
             file://dolt-fix.patch \
"

S = "${WORKDIR}/git"
PR = "${INC_PR}.0"
