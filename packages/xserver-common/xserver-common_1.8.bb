MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
PR = "r1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"


# we are using a gpe-style Makefile
inherit gpe

SRC_URI += "file://100dpi.patch;patch=1 \
            file://hx4700.patch;patch=1"
