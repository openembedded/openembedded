FILES_${PN} = "/usr/lib/aspell/* /usr/share/aspell/*"

DEPENDS = "aspell-native"

do_configure() {
	cd ${S}
	export dictdir=/usr/lib/aspell/
	export datadir=/usr/share/aspell/
	DESTDIR=${D} ./configure
}

do_compile() {
        export dictdir=/usr/lib/aspell/
	export datadir=/usr/share/aspell/
	dictdir=/usr/lib/aspell oe_runmake
}

do_install() {
        export dictdir=/usr/lib/aspell/
        export datadir=/usr/share/aspell/
	oe_runmake install
}

