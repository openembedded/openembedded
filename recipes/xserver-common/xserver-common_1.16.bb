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

SRC_URI[md5sum] = "237d27a5b46d1fa88fb43fb1a40cf209"
SRC_URI[sha256sum] = "c93e01cd754e8cafc6e02d32a7304d4b152e6aba9e6b0bcaea9ded12263f24b4"
