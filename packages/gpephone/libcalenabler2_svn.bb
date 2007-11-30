DESCRIPTION = "LiPS calendar API."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 sqlite3 libical"
PV = "0.0+svn-${SRCREV}"
PR = "r0"

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

do_stage () {
    autotools_stage_all
}

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"

DEFAULT_PREFERENCE = "-1"
