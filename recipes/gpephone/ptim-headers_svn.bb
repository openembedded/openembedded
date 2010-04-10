DESCRIPTION = "Phone input method - shared headers"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+"
PV = "0.1+svnr-${SRCREV}"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/ptim;module=imheaders"

S = "${WORKDIR}/imheaders"

DEFAULT_PREFERENCE = "-1"

do_stage () {
    autotools_stage_all
}
