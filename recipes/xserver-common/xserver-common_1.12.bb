require xserver-common.inc

PR = "r1"

SRC_URI_append = " file://setDPI.sh \
	           file://rxvt-less-pink.diff;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
