LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "lxt ncurses filemanager xtree clone"
PRIORITY = "optional"
DEPENDS = "ncurses"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/lxt-1.0"

SRC_URI = "http://www.xtreefanpage.org/download/lxt-1.0.tgz \
	   file://lxt.patch;patch=1"
S = "${WORKDIR}/lxt"

do_install() {
	install -d ${D}${bindir}/
	install -m 755 -D ${S}/lxt ${D}${bindir}/lxt
}

SRC_URI[md5sum] = "c703192481d94dfa3f4e24eed22c8182"
SRC_URI[sha256sum] = "daa670b686f959ab15e457425e57c50f0b973ee4d24d6a4171c33f467961ad1d"
