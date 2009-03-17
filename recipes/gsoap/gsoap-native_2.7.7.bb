require gsoap_${PV}.bb

DEPENDS = ""
PR = "r1"

SRC_URI += "file://use-just-built-binary.patch;patch=1"

inherit native

do_stage() {
	autotools_stage_all
}

do_install() {
	:
}
