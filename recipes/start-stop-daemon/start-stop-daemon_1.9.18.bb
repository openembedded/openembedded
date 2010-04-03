DESCRIPTION = "Debian's start-stop-daemon utility"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "PD"
PR = "r0"

SRC_URI = "file://start-stop-daemon.c"

S = "${WORKDIR}"

do_configure() {
	:
}

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/start-stop-daemon.c -o start-stop-daemon
}

do_install () {
	install -d ${D}/${base_sbindir}
	install -m 0755 ${S}/start-stop-daemon ${D}/${base_sbindir}/start-stop-daemon
}
