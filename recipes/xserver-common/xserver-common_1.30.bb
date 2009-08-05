DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r2"

PACKAGE_ARCH = "all"
DEFAULT_PREFERENCE = "-1"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://89xdgautostart.sh \
file://0018-zaurus-fixed-machine-names.patch;patch=1 \
file://0019-keymap-fixed-machine-names.patch;patch=1 \
file://0020-keymap-fixed-machine-names-again.patch;patch=1 \
file://0021-xserver-introduced-MOUSE-variable-for-mouse-argument.patch;patch=1 \
file://0022-xserver-fix-syntax-error.patch;patch=1 \
"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}
