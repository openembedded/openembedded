DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"
PR = "r1"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI += "file://remove-run-calibrate-sh.patch;patch=1"