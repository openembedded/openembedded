SECTION = "base"
require e2fsprogs.inc
inherit native

PR = "r1"
DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF = ""

PACKAGES = ""
DEPENDS = ""

do_stage () {
        oe_runmake install
}
