require dt.inc

PR = "${INC_PR}.1"

SRC_URI_append_linux-uclibc = " file://no_aio.patch;patch=1 "
SRC_URI_append_linux-uclibcgnueabi = " file://no_aio.patch;patch=1 "

do_install() {
	install -d ${D}${bindir}
	install -m 0755 dt ${D}${bindir}
}
