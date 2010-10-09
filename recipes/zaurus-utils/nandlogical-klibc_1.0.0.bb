require nandlogical_${PV}.bb

inherit klibc

do_compile() {
        ${CC} ${CFLAGS} ${LDFLAGS} -static -I${STAGING_INCDIR} nandlogical.c -o nandlogical
}

FILESPATHPKG =. "nandlogical:"
