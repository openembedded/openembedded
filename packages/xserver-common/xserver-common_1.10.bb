MAINTAINER  = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"
PR = "r1"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
		   file://calibrate_zaurusd.patch;patch=1 \
		   file://poodle-xmodmap-2.6.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
