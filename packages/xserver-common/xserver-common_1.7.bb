MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"
PR = "r1"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe
