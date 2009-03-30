DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe
