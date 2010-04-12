require xserver-common.inc

PR = "r1"

SRC_URI_append = " file://setDPI.sh \
	           file://rxvt-less-pink.diff;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "9e66d7699ca6bad1c3a5914ac8bfcb91"
SRC_URI[sha256sum] = "e82ec094d193cdd91aba699eff95fa6adaa01235f9ec4a68b1dd022c1b4496ef"
