DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 sqlite libgpewidget"
PR = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools pkgconfig gpe

do_stage () {
        autotools_stage_all
}
