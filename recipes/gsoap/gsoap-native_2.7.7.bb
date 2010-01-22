require gsoap_${PV}.bb

DEPENDS = ""
PR = "r1"

EXTRA_OEMAKE = ""

inherit native

do_stage() {
	autotools_stage_all
}

do_install() {
	:
}
