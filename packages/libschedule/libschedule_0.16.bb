LICENSE = "LGPL"
PR = "r0"
DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0 sqlite"
GPE_TARBALL_SUFFIX = "bz2"

inherit autotools pkgconfig gpe 


do_stage () {
autotools_stage_all
}

