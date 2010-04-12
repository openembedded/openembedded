DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r1"

PACKAGE_ARCH = "all"
DEFAULT_PREFERENCE = "-1"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://89xdgautostart.sh"

SRC_URI_append_angstrom = " file://xtscal-fix.patch;patch=1 "
RDEPENDS_${PN}_append_angstrom = " tslib-calibrate "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}

SRC_URI[md5sum] = "cdb63bb95074cfb778250defc3ca585e"
SRC_URI[sha256sum] = "a10641a046f39d6044882ec8bf44d28020291b75006374245daab1b73c0dab15"
