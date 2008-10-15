SECTION = "apps"
PR = "r0"

SRC_URI = "http://www.sentex.net/~mwandel/jhead/jhead-2.6.tar.gz \
           file://makefile.patch;patch=1"

S = "${WORKDIR}/jhead-2.6"

inherit autotools

do_configure() {
	:
}

do_install() {
	install -d ${D}/bin
	autotools_do_install
}
