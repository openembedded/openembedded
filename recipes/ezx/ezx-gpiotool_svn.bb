DESCRIPTION = "Gpiotool can read/write gpio configuration from userspace."
SECTION = "devel"
LICENSE = "GPL"
HOMEPAGE = "http://www.openezx.org"
AUTHOR = "Harald Welte"
SRCREV = "1877"
PV = "${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.openezx.org/trunk/src/userspace;module=gpiotool;proto=http"
S = "${WORKDIR}/gpiotool"

do_compile() {
	for i in mmio.c gpiotool.c gpio.c
	do
		${CC} ${CFLAGS} -c $i
	done
	${CC} ${CFLAGS} -o ezx-gpiotool mmio.o gpiotool.o gpio.o
}

do_stage() {
	:
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ezx-gpiotool ${D}${sbindir}
}
