require exalt.inc

DEPENDS = "ecore edbus libexalt"

do_stage() {
    autotools_stage_all
}

EXALT_MODULE = "libexalt_dbus"
