DESCRIPTION = "GSM libraries and daemons implementing the 07.10 specification"
HOMEPAGE = "http://www.openmoko.org"
LICENSE = "GPL"
SECTION = "libs/gsm"
PROVIDES += "gsmd"
PV = "0.0+svn${SRCDATE}"
PR = "r2"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target;module=gsm;proto=http"
S = "${WORKDIR}/gsm"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}

PACKAGES =+ "${PN}-tools gsmd"
RDEPENDS_${PN} = "gsmd"
FILES_${PN}-tools = "${bindir}/*"
FILES_gsmd = "${sbindir}/gsmd"

PACKAGES_DYNAMIC = "libgsmd* gsmd"

