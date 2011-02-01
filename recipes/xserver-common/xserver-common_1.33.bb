DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r9"

PACKAGE_ARCH = "all"
DEFAULT_PREFERENCE = "-1"

RCONFLICTS_${PN} = "xserver-kdrive-common"
RREPLACES_${PN} = "xserver-kdrive-common"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI[md5sum] = "2df46d6b1bbac9f3e5e7e3191ccdd3e4"
SRC_URI[sha256sum] = "4576ccca80730f1860a273df38b9f917cf906eca9865e108d76fc5460e006d87"

SRC_URI_append = " file://loop.patch;striplevel=3 \
                   file://rgba.diff \
                   file://setDPI.sh \
                   file://89xdgautostart.sh \
                   file://Xserver-virtex.patch"

SRC_URI_append_angstrom = " file://xtscal-fix.patch "
RDEPENDS_${PN}_append_angstrom = " tslib-calibrate "
RDEPENDS_${PN}_append_shr = " xinput-calibrator "

SRC_URI_append_shr = " file://89xTs_Calibrate.xinput_calibrator.patch \
                       file://90xXWindowManager.patch \
                       file://Xserver.add.nocursor.for.gta.patch \
                       file://Xserver.add.xserver-system.patch \
                       file://Xserver.add.dpi.for.gta.patch \
		       file://Xserver.n900.patch"

SRC_URI_append_at91 =	" file://89xTs_Calibrate.xinput_calibrator.patch \
			"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}

