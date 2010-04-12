DESCRIPTION = "a recursive directory listing program"
HOMEPAGE = "http://mama.indstate.edu/users/ice/tree/"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "ftp://mama.indstate.edu/linux/tree/tree-${PV}.tgz"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tree ${D}${bindir}/tree
}

SRC_URI[md5sum] = "b86a3091ec93e1e13e81020fa33b6270"
SRC_URI[sha256sum] = "d830f5c79fa86bd5b40ce99e70408e7e734361a14dc0bea5bffa0586cfde9715"
