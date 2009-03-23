DESCRIPTION = "Nandlogical for Sharp mtd1"
LICENSE = "GPL"
DEPENDS = "mtd-utils"
COMPATIBLE_MACHINE = "(poodle|c7x0|akita|spitz|tosa)"
PR = "r1"

SRC_URI = "file://nandlogical.c"

S = "${WORKDIR}/${P}"

do_compile () {
	${CC} -o nandlogical ${WORKDIR}/nandlogical.c
}

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/${P}/nandlogical ${D}${bindir}/
}
