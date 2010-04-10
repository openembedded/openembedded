DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r0"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "7810436d0085f8808a09ea6377526c71"
SRC_URI[sha256sum] = "723dbbdfac6e421aa3343a2f1cef7cfb998bb5c045dcf0df870aeba6dd78b79d"
