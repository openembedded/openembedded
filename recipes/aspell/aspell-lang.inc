FILES_${PN} = "/usr/lib/aspell* /usr/share/aspell*"

DEPENDS = "aspell-native"

do_configure() {
	cd ${S}
	DESTDIR=${D} ./configure --vars ASPELL=${STAGING_BINDIR_NATIVE}/aspell
}

do_compile() {
	sed -i -e "s|dictdir.*lib|dictdir = ${libdir}|" Makefile
	sed -i -e "s|datadir.*lib|datadir = ${libdir}|" Makefile
	oe_runmake
}

do_install() {
	unset datadir
	oe_runmake install
}

