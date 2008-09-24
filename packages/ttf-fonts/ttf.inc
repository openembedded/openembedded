SECTION = "fonts"
PRIORITY = "optional"
RRECOMMENDS += "font-update-common"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
	if [ -e *.ttf ]; then
		install -m 0644 *.ttf ${D}${datadir}/fonts/truetype/
	fi
    if [ -e *.ttc ]; then
        install -m 0644 *.ttc ${D}${datadir}/fonts/truetype/
    fi
}

pkg_postinst_append() {
    update-fonts
}

pkg_postrm_append() {
    update-fonts
}

PACKAGE_ARCH = "all"
