SECTION = "e/utils"
DEPENDS = "edje-utils"
RDEPENDS = "etk"

S = "${WORKDIR}/git/etk/${PN}/"

do_compile() {
        ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/. -fd ${S}/. ${S}/default.edc -o ${S}/default.edj
}

do_install() {
        install -d ${D}${datadir}/etk/themes.${PN}/
        install -m 0644 ${S}/default.edj ${D}${datadir}/etk/themes.${PN}/
}

FILES_${PN} = "${datadir}/etk/themes.${PN}"

inherit update-alternatives

ALTERNATIVE_NAME = "etk-theme"
ALTERNATIVE_LINK = "${datadir}/etk/themes"
ALTERNATIVE_PATH = "${datadir}/etk/themes.${PN}"
ALTERNATIVE_PRIORITY ?= 1

pkg_postinst() {
        if [[ -e /usr/share/etk/themes && ! -h /usr/share/etk/themes ]] ; then
                echo "Removing old /usr/share/etk/themes directory. Will be replaced with link managed by update-alternatives"
                echo "Press enter to continue"
                read
                rm -rf /usr/share/etk/themes
        fi
}
