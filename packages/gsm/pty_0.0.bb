DESCRIPTION = "Forwards a socket to a tty"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "file://pty.c"

do_compile() {
	cp ${WORKDIR}/*.c ${S}/
	${CC} pty.c -o pty -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 pty ${D}${bindir}/
}
