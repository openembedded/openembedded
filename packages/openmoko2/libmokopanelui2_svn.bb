SECTION = "openmoko/libs"
DEPENDS = "gtk+ matchbox-panel-2"
PV = "0.3.0+svnr${SRCREV}"
FILE_PR = "r0"

inherit openmoko2

do_stage() {
        autotools_stage_all
}
