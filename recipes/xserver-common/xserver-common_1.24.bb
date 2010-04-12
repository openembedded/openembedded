DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r3"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://89xdgautostart.sh \
"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
	install -m 0755 "${WORKDIR}/89xdgautostart.sh" "${D}/etc/X11/Xsession.d/89xdgautostart"
}

SRC_URI[md5sum] = "6d7aaa9c267427ddb78faf008cf78187"
SRC_URI[sha256sum] = "8109646b77c08a0f269531ad42475782101a88681c2590453f4a5c9fe4681932"
