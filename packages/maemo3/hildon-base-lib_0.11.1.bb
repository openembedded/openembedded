#needs maemo gtk stubs:
# gtk_style_lookup_logical_color	gtk/gtkstyle.[ch]
# see http://maemo.org/maemowiki/MaemoGtk210Changes

LICENSE = "LGPL"

DEPENDS = "gtk+ virtual/libx11"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}


