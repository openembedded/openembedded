SECTION = "base"
PRIORITY = "optional"
DEPENDS = ""
DESCRIPTION = "Event driven system init"
LICENSE = "MPL LGPL"

inherit autotools pkgconfig 

do_stage () {
 	autotools_stage_all
}
