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



SRC_URI[md5sum] = "574789e014988398dca2debc65c02097"
SRC_URI[sha256sum] = "6a2f50c1a6e83c94618a271cc9b7ce0460fd1fe58adb12e05d0b1b07b43e4beb"
