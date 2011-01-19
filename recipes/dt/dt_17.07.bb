require dt.inc

PR = "${INC_PR}.1"

SRC_URI_append_libc-uclibc = " file://no_aio.patch "

do_install() {
	install -d ${D}${bindir}
	install -m 0755 dt ${D}${bindir}
}

SRC_URI[md5sum] = "fc3373e30868698b90f02cc5fab9aabd"
SRC_URI[sha256sum] = "6a213b8da2b8907c4f1633c3b90229085ac239e4d43aa5879b0123c21f951cab"
