require roadmap.inc

SECTION = "opie/applications"

inherit palmtop

QT_LIBRARY = '${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte",d)}'
QT_LIBRARY_append_c7x0 = " -laticore"

do_configure() {
	echo removing pregenerated stuff
	find . -name "moc*"|xargs rm -f
}
