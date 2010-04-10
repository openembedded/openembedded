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

SRC_URI[md5sum] = "8ec44fda9476391ed372f835d5358fe8"
SRC_URI[sha256sum] = "9505377f6b4d4b657889e8468fca8049c8c2c46c3ddd03bb4eef0e7b2e1bad3b"
