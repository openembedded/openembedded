LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "lxt ncurses filemanager xtree clone"
PRIORITY = "optional"
MAINTAINER = "Lorn Potter <lpotter@trolltech.com>"
DEPENDS = "ncurses"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/lxt-1.0"

SRC_URI = "http://www.xtreefanpage.org/download/lxt-1.0.tgz \
	   file://lxt.patch;patch=1"
S = "${WORKDIR}/lxt"

do_install() {
	install -d ${D}${bindir}/
	install -m 755 -D ${S}/lxt ${D}${bindir}/lxt
}
