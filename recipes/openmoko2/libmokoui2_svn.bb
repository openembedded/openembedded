SECTION = "openmoko/libs"
DEPENDS = "gtk+"
DEPENDS_shr += " gnome-python"
PV = "0.1.0+svnr${SRCREV}"
PR = "r2"

inherit openmoko2

LICENSE = "LGPL"
EXTRA_OECONF_shr += " --enable-python"
do_configure_prepend() {
        touch gtk-doc.make
}

do_stage() {
        autotools_stage_all
}

