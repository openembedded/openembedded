SECTION = "console/utils"
DESCRIPTION = "Console utility for padding a file (filling with 0 to reach a specified length)"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/pad"
SRC_URI = "file://pad.c"
LICENSE = "PD"
PR = "r1"
inherit native

do_compile() {
	cp ${WORKDIR}/pad.c .
	${CC} -I. -o pad pad.c
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 pad ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
