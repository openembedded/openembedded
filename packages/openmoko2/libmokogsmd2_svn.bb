SECTION = "openmoko/libs"
DEPENDS = "libgsmd glib-2.0"
PV = "0.1.0+svnr${SRCREV}"
FILE_PR = "r2"

inherit openmoko2

do_stage() {
        autotools_stage_all
}

