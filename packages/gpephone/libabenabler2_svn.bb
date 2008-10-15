DESCRIPTION = "LiPS address book library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 librecord2 gconf sqlite3"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
        autotools_stage_all
}

DEFAULT_PREFERENCE = "-1"

LDFLAGS += " -L${STAGING_LIBDIR}"
