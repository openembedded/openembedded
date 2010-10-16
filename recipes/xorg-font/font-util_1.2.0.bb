require xorg-font-common.inc

PACKAGE_ARCH = "${BASE_PACKAGE_ARCH}"

DESCRIPTION = "X font utils."

DEPENDS = "util-macros"
RDEPENDS_${PN} = "mkfontdir mkfontscale encodings"
BBCLASSEXTEND = "native"

PE = "1"
PR = "${INC_PR}.0"

do_configure_prepend() {
        sed -i "s#MAPFILES_PATH=\`pkg-config#MAPFILES_PATH=\`PKG_CONFIG_PATH=\"${STAGING_LIBDIR_NATIVE}/pkg-config\" pkg-config#g" fontutil.m4.in
}

SRC_URI[archive.md5sum] = "1bdd8ed070e02b2165d7b0f0ed93280b"
SRC_URI[archive.sha256sum] = "dbbac617ae6cdf6f459e602361211d217f4bad5ad8bfb6adcede6196693f9712"
