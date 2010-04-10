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

SRC_URI[md5sum] = "da63b0ed460c0f44b9f85774caf3fb0d"
SRC_URI[sha256sum] = "a33977201ff13a4c08d3a74de0fcdbe7f072e4a92a261d5f39fbf16aab069050"
