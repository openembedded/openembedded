require xserver-common.inc

SRC_URI_append = " file://setDPI.sh \
		   file://calibrate_zaurusd.patch;patch=1 \
		   file://w100.patch;patch=1 \
		   file://poodle-xmodmap-2.6.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "6a5f7bd7d20c6bbcb5ab3db4f425afac"
SRC_URI[sha256sum] = "3494a5fb80514cd1f1be784f08bd9fce12b080dbdfeb9b7ad50961094e901d50"
