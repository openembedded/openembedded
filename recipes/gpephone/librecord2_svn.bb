LICENSE     = "LiPS"
DESCRIPTION = "LiPS database API."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 util-linux-ng sqlite3"
PR          = "r0"
PV = "0.1+svnr-${SRCREV}"

DEFAULT_PREFERENCE = "-1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"


LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}
