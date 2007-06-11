LICENSE     = "GPL"
DESCRIPTION = "handoff library for GPE calendar"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS  = "glib-2.0"

inherit pkgconfig gpe autotools

GPE_TARBALL_SUFFIX = "bz2"

do_stage () {
        autotools_stage_all
}
