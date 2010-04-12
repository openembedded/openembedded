DESCRIPTION = "GNOME keyboard library"
LICENSE = "LGPL"
SECTION = "x11/gnome/libs"

DEPENDS = "gconf libgnome libxklavier"

inherit gnome

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

do_stage() {
    autotools_stage_all
}





SRC_URI[archive.md5sum] = "b0989c4a2dbe2b5dd892d14195674f2b"
SRC_URI[archive.sha256sum] = "72da2cc218de666a0ffa8896ae2d01bce3f46fde7072f2aa937c2bcd2d312668"
