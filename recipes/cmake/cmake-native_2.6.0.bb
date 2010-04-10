inherit native
require cmake.inc

do_stage() {
    oe_runmake install
    autotools_stage_all
}

do_install() {
	:
}

SRC_URI[md5sum] = "e95ae003672dfc6c8151a1ee49a0d4a6"
SRC_URI[sha256sum] = "4999d3054a04e6cf4847a72316e32e9e98e6152b1fd72adc87d15e305f990f27"
