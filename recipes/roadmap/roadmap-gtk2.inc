require roadmap.inc

SECTION = "x11/applications"

DEPENDS += "agg gtk+"

EXTRA_OEMAKE = "DESKTOP=GTK2 AGG=rgb565 \
                POPT=NO SCRIPTS= BUILD= INSTALLDIR=/usr DESTDIR=${D} \
                desktopdir=${D}${datadir}/applications"

CFLAGS += " -I${STAGING_INCDIR}/agg2 "
