DESCRIPTION = "A tool to make device nodes"
LICENSE = "GPLv2"
SECTION = "base"
PRIORITY = "required"
PR = "r11"

SRC_URI = "file://makedevs.c"
S = "${WORKDIR}/makedevs-${PV}"

inherit update-alternatives

do_configure() {
	install -m 0644 ${WORKDIR}/makedevs.c ${S}/
}

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o ${S}/makedevs ${S}/makedevs.c
}

do_install_virtclass-native() {
        install -d ${D}${bindir}/
        install -m 0755 ${S}/makedevs ${D}${bindir}/
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/makedevs ${D}${base_sbindir}/makedevs.makedevs
}

ALTERNATIVE_PATH = "${base_sbindir}/makedevs.makedevs"
ALTERNATIVE_NAME = "makedevs"
ALTERNATIVE_LINK = "${base_sbindir}/makedevs"
ALTERNATIVE_PRIORITY = "100"

BBCLASSEXTEND = "native"

NATIVE_INSTALL_WORKS = "1"
