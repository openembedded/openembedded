DESCRIPTION = "LiPS calendar API."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 sqlite3 libical libalmmgr"
SRCREV = "1410"
PV = "0.0+svnr${SRCPV}"
PE = "1"
PR = "r0"


inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
    autotools_stage_all
}

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"

DEFAULT_PREFERENCE = "-1"
