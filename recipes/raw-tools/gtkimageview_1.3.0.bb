DESCRIPTION = "GtkImageView is a simple image viewer widget for GTK."
DEPENDS = "gtk+"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/gtkimageview-${PV}.tar.gz"

inherit autotools pkgconfig


do_configure() {
       gnu-configize
       libtoolize --force
       oe_runconf
}

do_stage() {
       autotools_stage_all
}


