require nandlogical_${PV}.bb

do_compile () {
	${CC} -o nandlogical ${WORKDIR}/nandlogical.c -static
}
