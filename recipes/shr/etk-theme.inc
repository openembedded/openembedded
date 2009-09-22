SECTION = "e/utils"
DEPENDS = "edje-native"
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
        if [[ -e ${ALTERNATIVE_LINK} && ! -h ${ALTERNATIVE_LINK} ]] ; then
                echo "warn: ${ALTERNATIVE_LINK} exists and it's not a link!"
                echo "warn: It will be replaced with link managed by update-alternatives"
                echo "warn: Moving ${ALTERNATIVE_LINK} to ${ALTERNATIVE_LINK}.old."
                echo "warn: It should be empty but probably isn't!"
                echo "warn: Check what's left there and remove it manually."
                mv -f ${ALTERNATIVE_LINK} ${ALTERNATIVE_LINK}.old
        fi
}
