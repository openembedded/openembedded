MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"

PR = "r12"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
		   file://calibrate_zaurusd.patch;patch=1 \
		   file://softkeys-slcxxxx-xmodmap.patch;patch=1 \
		   file://softkeys-c7x0.patch;patch=1 \
		   file://at-fix-slcxxxx.patch;patch=1 \
		   file://load-xmodmap-k26.patch;patch=1 \
		   file://Xserver-udev-input-helper.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
