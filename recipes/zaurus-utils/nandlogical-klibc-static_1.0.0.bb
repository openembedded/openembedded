require nandlogical_${PV}.bb

FILESPATHPKG =. "nandlogical:"

SRC_URI_append = " file://mtd-user.h \
		    file://mtd-abi.h \
		    "
DEPENDS += "klibc"

export CC = ${TARGET_PREFIX}klcc

# standard oe cflags don't work with klcc
export CFLAGS = ""
export CPPFLAGS = ""
export LDFLAGS = ""

do_configure_prepend() {
    sed -i 's:<mtd/mtd-user.h>:"mtd-user.h":g' '${S}/nandlogical.c'
    sed -i 's:<mtd/mtd-abi.h>:"mtd-abi.h":g' '${S}/mtd-user.h'
}

do_compile() {
        ${CC} nandlogical.c -o nandlogical ${CFLAGS} ${LDFLAGS} -static
}
