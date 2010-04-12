DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r0"

PACKAGE_ARCH = "all"
DEFAULT_PREFERENCE = "-1"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://89xdgautostart.sh"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
	sed -i 's:^BINDIR=.*$:BINDIR=${bindir}:' ${D}/etc/X11/Xserver
}

SRC_URI[md5sum] = "ac2515a68bc3c5cf3729aa2ff4edebdf"
SRC_URI[sha256sum] = "d9991f22b5f52bc4cfe579f4e3fbb6d04f8d7ce575bd04a94372c14584ddfd34"
