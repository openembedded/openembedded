SECTION = "fonts"
PRIORITY = "optional"
RRECOMMENDS += "font-update-common"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    find ./ -name "*.ttf" -or -name "*.ttc" -exec install -m 0644 {} ${D}${datadir}/fonts/truetype/ \;
}

pkg_postinst_append() {
    update-fonts
}

pkg_postrm_append() {
    update-fonts
}

PACKAGE_ARCH = "all"
