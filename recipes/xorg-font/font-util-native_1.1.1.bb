inherit native
require xorg-font-common.inc

XORG_PN = "font-util"

DEPENDS = "bdftopcf-native util-macros-native"

PE = "1"
PR = "${INC_PR}.1"

do_configure_prepend() {
        sed -i "s#MAPFILES_PATH=\`pkg-config#MAPFILES_PATH=\`PKG_CONFIG_PATH=\"${STAGING_LIBDIR_NATIVE}/pkg-config\" pkg-config#g" fontutil.m4.in
}
