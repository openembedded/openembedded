SECTION = "fonts"
PRIORITY = "optional"
RRECOMMENDS += "font-update-common"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    for f in *.ttf *.ttc
       do
          [ -f $f ] && install -m 0644 $f ${D}${datadir}/fonts/truetype/
       done
}

pkg_postinst_append() {
    update-fonts
}

pkg_postrm_append() {
    update-fonts
}

PACKAGE_ARCH = "all"
