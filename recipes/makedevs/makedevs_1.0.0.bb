DESCRIPTION = "A tool to make device nodes"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "required"

SRC_URI = "file://makedevs.c"
S = "${WORKDIR}/makedevs-${PV}"

PR = "r6"

inherit update-alternatives

do_configure() {
	install -m 0644 ${WORKDIR}/makedevs.c ${S}/
}

do_compile() {
	${CC} ${CFLAGS} -L${STAGING_LIBDIR}/ -o ${S}/makedevs ${S}/makedevs.c
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/makedevs ${D}${base_sbindir}/makedevs.makedevs
}

ALTERNATIVE_PATH = "${base_sbindir}/makedevs.makedevs"
ALTERNATIVE_NAME = "makedevs"
ALTERNATIVE_LINK = "${base_sbindir}/makedevs"
ALTERNATIVE_PRIORITY = "50"


