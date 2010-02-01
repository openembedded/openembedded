DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r5"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://89xdgautostart.sh \
                   file://avoid-rotated-server.patch;patch=1 \
                   file://ts-handling-cleanup.diff;patch=1 \
                   file://Xserver-at91.patch;patch=1 \
"

SRC_URI_append_angstrom = " file://xtscal-fix.patch;patch=1 "
RDEPENDS_${PN}_append_angstrom = " tslib-calibrate "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}
