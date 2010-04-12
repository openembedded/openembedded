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

SRC_URI[md5sum] = "fa3f1d3243fab7bc3b81688a3f2eec25"
SRC_URI[sha256sum] = "55a65214c19f9a61265fdef21ae4d7f59b725248d06c0595152c14774bd31065"
