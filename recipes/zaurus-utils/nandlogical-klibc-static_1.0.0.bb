require nandlogical_${PV}.bb

FILESPATHPKG =. "nandlogical:"

DEPENDS += "klibc"

export CC = ${TARGET_PREFIX}klcc

# standard oe cflags don't work with klcc
export CFLAGS = ""
export CPPFLAGS = ""
export LDFLAGS = ""

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -static -I${STAGING_INCDIR} nandlogical.c -o nandlogical
}
