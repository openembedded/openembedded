require xserver-common.inc

SRC_URI_append = " file://setDPI.sh \
		   file://calibrate_zaurusd.patch;patch=1 \
		   file://w100.patch;patch=1 \
		   file://poodle-xmodmap-2.6.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
