require xserver-common.inc

PR = "r2"

SRC_URI_append = " file://setDPI.sh \
                   file://xserver-imageon.patch;patch=1 \
                   file://calibrate-only-if-ts.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}
