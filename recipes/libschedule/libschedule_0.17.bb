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

SRC_URI[md5sum] = "ba3a1063a9e8cd5a730b3871e468c227"
SRC_URI[sha256sum] = "802c72f5f11d60f5cb75ef8acc116c5ab0600e3bc099fc5accf8a997e463b374"
