inherit native

EXTRA_OECONF = "--without-gmp"
INHIBIT_AUTOTOOLS_DEPS = "1"
PATCHTOOL = "patch"

do_configure() {
	oe_runconf
}

do_install() {
	autotools_do_install
}

