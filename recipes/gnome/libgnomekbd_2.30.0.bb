DESCRIPTION = "GNOME keyboard library"
LICENSE = "LGPL"
SECTION = "x11/gnome/libs"

DEPENDS = "gconf libgnome libxklavier"

inherit gnome

SRC_URI[archive.md5sum] = "2c3a2dfac0da5c3748a06db905264429"
SRC_URI[archive.sha256sum] = "fc8f688901dfa293b1e5c14a0b56866837f0003d5b6a9ce971841735084d5b04"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}





