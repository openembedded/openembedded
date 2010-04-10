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





SRC_URI[archive.md5sum] = "43e4d090bc67a1984bebf551637783fd"
SRC_URI[archive.sha256sum] = "60f093b4fcbdfa12212d6e29dc2f7802a3234d8035f45efed4b426c0bb293c5a"
