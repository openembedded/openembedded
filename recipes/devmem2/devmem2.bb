DESCRIPTION = "Simple program to read/write from/to any location in memory."
SRC_URI = "http://www.lartmaker.nl/lartware/port/devmem2.c"
LICENSE = "GPLv2"
PR = "r3"

S = "${WORKDIR}"

do_compile() {
	${CC} -o devmem2 devmem2.c ${CFLAGS} ${LDFLAGS}
}

do_install() {
	install -d ${D}${bindir}
	install devmem2 ${D}${bindir}
}

SRC_URI[md5sum] = "be12c0132a1ae118cbf5e79d98427c1d"
SRC_URI[sha256sum] = "ec382c90af3ef2f49695ff14a4d6521e58ac482c4e29d6c9ebca8768f699c191"
