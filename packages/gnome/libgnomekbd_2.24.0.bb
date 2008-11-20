DESCRIPTION = "GNOME keyboard library"
LICENSE = "LGPL"

DEPENDS = "gconf libgnome libxklavier"

inherit gnome

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

do_stage() {
    autotools_stage_all
}




