SECTION = "devel"
include automake_${PV}.bb
DEPENDS = "autoconf-native"

inherit native

do_stage () {
	oe_runmake install
	install -d ${datadir}
	if [ ! -e ${datadir}/aclocal ]; then
		ln -sf aclocal-1.9 ${datadir}/aclocal
	fi
	if [ ! -e ${datadir}/automake ]; then
		ln -sf automake-1.9 ${datadir}/automake
	fi
}
