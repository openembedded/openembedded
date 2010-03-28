inherit native
require cmake.inc

do_install() {
	oe_runmake install
}
