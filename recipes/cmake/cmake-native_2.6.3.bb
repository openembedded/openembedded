inherit native
require cmake.inc

do_stage() {
    oe_runmake install
    autotools_stage_all
}

do_install() {
	:
}

SRC_URI[md5sum] = "5ba47a94ce276f326abca1fd72a7e7c6"
SRC_URI[sha256sum] = "3c3af80526a32bc2afed616e8f486b847144f2fa3a8e441908bd39c38b146450"
