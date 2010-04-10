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



SRC_URI[archive.md5sum] = "1b714ba04835fb49511f9e1444a5ea4c"
SRC_URI[archive.sha256sum] = "210ed5803109a8cef3b2ab1195bc73fe3385a97a8749d01673e020642d8e5a71"
