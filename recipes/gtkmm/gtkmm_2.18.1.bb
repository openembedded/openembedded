require gtkmm.inc

DEPENDS += "pangomm"

EXTRA_OECONF = " --disable-documentation "

do_configure() {
    libtoolize --force
    gnu-configize
    oe_runconf
}


