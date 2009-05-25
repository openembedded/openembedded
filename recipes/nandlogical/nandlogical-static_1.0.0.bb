require nandlogical_${PV}.bb

do_compile () {
	${CC} nandlogical.c -o nandlogical ${CFLAGS} ${LDFLAGS} -static
}
