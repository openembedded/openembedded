require gdb-cross.inc

DEPENDS = "ncurses-sdk"

inherit sdk

PR = "r1"

do_configure_prepend() {
	for i in $(find ${S} -name "warning*m4") ; do 
		sed -i -e s:-Werror::g $i 
	done
    for i in $(find ${S} -name "configure.ac") ; do
		sed -i -e s:-Werror::g $i
	done
	for i in $(find ${S} -name "configure") ; do
		sed -i -e s:-Werror::g $i
	done
}

do_stage() {
	:
}
