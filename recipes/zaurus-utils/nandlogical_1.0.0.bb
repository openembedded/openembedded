DESCRIPTION = "Nandlogical for Sharp mtd1"
LICENSE = "GPL"
DEPENDS = "mtd-utils"
COMPATIBLE_MACHINE = "(poodle|c7x0|akita|spitz|tosa)"
PR = "r3"

SRC_URI = "file://nandlogical.c"

S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} nandlogical.c -o nandlogical
}

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 nandlogical ${D}${bindir}/
}
