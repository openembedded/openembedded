inherit native
require xorg-font-common.inc

XORG_PN = "font-util"

DEPENDS = "bdftopcf-native util-macros-native"

PE = "1"
PR = "${INC_PR}.1"

do_configure_prepend() {
        sed -i "s#MAPFILES_PATH=\`pkg-config#MAPFILES_PATH=\`PKG_CONFIG_PATH=\"${STAGING_LIBDIR_NATIVE}/pkg-config\" pkg-config#g" fontutil.m4.in
}

SRC_URI[archive.md5sum] = "5c735ae6916b65186f3c876d76c27ce3"
SRC_URI[archive.sha256sum] = "a33f1e3b0d7c3fd7c3505ce68888fec3cf897353084187d96e1e821fe3c02f88"
