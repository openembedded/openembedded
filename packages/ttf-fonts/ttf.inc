DESCRIPTION ?= "TrueType font package ${PN}"
SECTION = "fonts"
PRIORITY = "optional"
RRECOMMENDS += "font-update-common"

# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}${datadir}/fonts/truetype/ \;
}

pkg_postinst_append() {
    update-fonts
}

pkg_postrm_append() {
    update-fonts
}

PACKAGE_ARCH = "all"
