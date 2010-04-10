require xserver-common.inc

PR = "r2"

SRC_URI_append = " file://setDPI.sh \
                   file://xserver-imageon.patch;patch=1 \
                   file://calibrate-only-if-ts.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "bd12dffbef3b5a87bf96fa3d8978127b"
SRC_URI[sha256sum] = "fdfa2591756c5709d0531cc73fed07fb4bd50509c706c31ebd5c7301930be806"
