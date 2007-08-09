DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r7"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://xserver-imageon.patch;patch=1 \
                   file://calibrate-only-if-ts.patch;patch=1 \
		   file://softkeys-c7x0.patch;patch=1 \
		   file://load-xmodmap-k26.patch;patch=1 \
		   file://Xserver-udev-input-helper.patch;patch=1 \
		   file://sl-cxx00-modmap.patch;patch=1 \
		   "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
