require roadmap.inc

SECTION = "x11/applications"

DEPENDS = "agg expat gtk+"

EXTRA_OEMAKE= "DESKTOP=GTK2 AGG=rgb565 \
               POPT=NO SCRIPTS= BUILD= \ 
               INSTALLDIR=/usr DESTDIR=${D}"

CFLAGS += " -I${STAGING_INCDIR}/agg2 "

do_compile() {
        oe_runmake runtime $(TOOLS) icons
}

do_install() {
        oe_runmake install
        mv ${D}/usr/applications ${D}/usr/share/

        install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}

FILES_${PN} += "${datadir}/roadmap"
