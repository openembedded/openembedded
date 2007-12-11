DESCRIPTION = "LiPS address book library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 librecord2 gconf sqlite3"
PV = "0.0+svn-${SRCDATE}"
PR = "r0"

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

inherit gpephone pkgconfig autotools

do_stage () {
        autotools_stage_all
}

DEFAULT_PREFERENCE = "-1"

LDFLAGS += " -L${STAGING_LIBDIR}"
