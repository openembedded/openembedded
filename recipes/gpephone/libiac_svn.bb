DESCRIPTION = "LiPS IPC library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ gtk-doc"
PV = "1.0+svnr-${SRCREV}"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

do_stage () {
        autotools_stage_all
}
