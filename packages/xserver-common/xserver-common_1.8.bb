MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"

PR = "r3"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append_akita = " file://Xdefaults-200DPI.patch;patch=1"
SRC_URI_append_spitz = " file://Xdefaults-200DPI.patch;patch=1"
SRC_URI_append_c7x0 = " file://Xdefaults-200DPI.patch;patch=1"
SRC_URI_append_tosa = " file://Xdefaults-200DPI.patch;patch=1"
