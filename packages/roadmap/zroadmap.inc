require roadmap.inc

PARALLEL_MAKE = ""

SECTION = "opie/applications"

inherit palmtop

QT_LIBRARY = '${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte",d)}'
QT_LIBRARY_append_c7x0 = " -laticore"

EXTRA_OEMAKE = "DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} QTDIR=${QTDIR} \
                POPT=NO SCRIPTS= BUILD= INSTALLDIR=/usr DESTDIR=${D} \
                icondir=${D}${palmtopdir}/pics \
                desktopdir=${D}${palmtopdir}/apps/Applications \
                CFLAGS="-DQWS -I${S} ${OE_QMAKE_CFLAGS} -I${OE_QMAKE_INCDIR_QT}" \
                LDFLAGS="${OE_QMAKE_LDFLAGS} -L${OE_QMAKE_LIBDIR_QT} -Wl,-rpath-link,${OE_QMAKE_LIBDIR_QT}""

do_configure() {
	echo removing pregenerated stuff
	find . -name "moc*"|xargs rm -f
}

