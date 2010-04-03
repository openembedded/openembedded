DESCRIPTION = "Helper lib for keyboard management"
LICENSE = "LGPL"

PR = "r2"

DEPENDS = "xkbcomp gtk+ iso-codes "

inherit gnome

EXTRA_OECONF = "--with-xkb-bin-base=/usr/bin"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  libxklavier.pc
}


