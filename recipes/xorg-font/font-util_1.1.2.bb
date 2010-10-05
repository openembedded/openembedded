require xorg-font-common.inc

PACKAGE_ARCH = "${BASE_PACKAGE_ARCH}"

DESCRIPTION = "X font utils."

DEPENDS = "util-macros"
RDEPENDS_${PN} = "mkfontdir mkfontscale encodings"

PE = "1"
PR = "${INC_PR}.2"

do_configure_prepend() {
        sed -i "s#MAPFILES_PATH=\`pkg-config#MAPFILES_PATH=\`PKG_CONFIG_PATH=\"${STAGING_LIBDIR_NATIVE}/pkg-config\" pkg-config#g" fontutil.m4.in
}

SRC_URI[archive.md5sum] = "6a56a1a93f2e07f0323db988e4ebfcce"
SRC_URI[archive.sha256sum] = "fc1996a9f8fcb1c038a69f30a3da70f13945e308992e6ef2c7fa3a82a1412a88"
