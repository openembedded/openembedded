SECTION = "console/utils"
DESCRIPTION = "Console utility for padding a file (filling with 0 to reach a specified length)"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/pad"
SRC_URI = "file://pad.c"
LICENSE = "PD"
inherit native

do_compile() {
	cp ${WORKDIR}/pad.c .
	${CC} -I. -o pad pad.c
}

do_stage() {
	install -m 0755 pad ${STAGING_BINDIR}/
}
