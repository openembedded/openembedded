DESCRIPTION = "LiPS IPC library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ gtk-doc"
SRCREV = "1590"
PV = "1.0+svnr${SRCPV}"
PE = "1"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

do_stage () {
        autotools_stage_all
}
