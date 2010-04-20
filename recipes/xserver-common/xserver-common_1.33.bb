DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"

PACKAGE_ARCH = "all"
DEFAULT_PREFERENCE = "-1"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI[md5sum] = "2df46d6b1bbac9f3e5e7e3191ccdd3e4"
SRC_URI[sha256sum] = "4576ccca80730f1860a273df38b9f917cf906eca9865e108d76fc5460e006d87"

SRC_URI_append = " file://loop.patch;patch=1;pnum=3 \
                   file://rgba.diff;patch=1 \
                   file://setDPI.sh \
                   file://89xdgautostart.sh"

SRC_URI_append_angstrom = " file://xtscal-fix.patch;patch=1 "
RDEPENDS_${PN}_append_angstrom = " tslib-calibrate "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}

