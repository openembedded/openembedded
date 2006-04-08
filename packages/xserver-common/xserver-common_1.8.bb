MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"

PR = "r2"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_akita += " file://100dpi.patch;patch=1"
SRC_URI_spitz += " file://100dpi.patch;patch=1"
SRC_URI_c7x0 += " file://100dpi.patch;patch=1"
SRC_URI_tosa += " file://100dpi.patch;patch=1"
