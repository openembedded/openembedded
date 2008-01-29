SECTION = "fonts"
PRIORITY = "optional"
RDEPENDS += "font-update-common"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    install -m 0644 ${S}/*.ttf ${D}${datadir}/fonts/truetype/
}

pkg_postinst_append() {
    update-fonts
}

pkg_postrm_append() {
    update-fonts
}

PACKAGE_ARCH = "all"
