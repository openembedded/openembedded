DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
RRECOMMENDS_${PN} = "xtscal"
PR = "r5"

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
file://0023-Xserver-provide-screen-argument-only-for-non-X.org-s.patch;patch=1 \
file://0024-Xserver-move-nearly-whole-functionality-to-xserver-c.patch;patch=1 \
file://0025-Makefile-move-modmaps-install-xserver-common.patch;patch=1 \
file://0026-98keymap-fixup-fixed-path-to-xmodmap-file.patch;patch=1 \
"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}

SRC_URI[md5sum] = "67320288d285a627391f54ed739fb12d"
SRC_URI[sha256sum] = "5de3bc0c021647606fd23863f44508f851252bebce579f920e020caed74b63f0"
