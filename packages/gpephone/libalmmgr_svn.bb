DESCRIPTION = "LiPS alarm framework library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 libiac"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

do_stage () {
        autotools_stage_all
}
