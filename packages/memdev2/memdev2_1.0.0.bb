DESCRIPTION = "Tool to read and write to arbitrary memory locations"
LICENSE = "GPL"
PR = "r0"

SRC_URI="http://free-electrons.com/pub/mirror/devmem2.c"

S = "${WORKDIR}"

do_compile () {
	${CC} -o devmem2 devmem2.c
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 devmem2 ${D}${sbindir}/
}
