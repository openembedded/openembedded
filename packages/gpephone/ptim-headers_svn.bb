DESCRIPTION = "Phone input method - shared headers"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+"
PV = "0.1+svn-${SRCDATE}"

inherit gpephone pkgconfig autotools

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/ptim;module=imheaders"

S = "${WORKDIR}/imheaders"

DEFAULT_PREFERENCE = "-1"

do_starge () {
    autotools_do_stage_all
}