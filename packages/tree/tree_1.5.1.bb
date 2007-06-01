DESCRIPTION = "a recursive directory listing program"
HOMEPAGE = "http://mama.indstate.edu/users/ice/tree/"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "ftp://mama.indstate.edu/linux/tree/tree-${PV}.tgz"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tree ${D}${bindir}/tree
}
