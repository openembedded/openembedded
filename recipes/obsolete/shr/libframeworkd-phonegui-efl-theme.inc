SECTION = "e/utils"
DEPENDS += "edje-native"

FILES_${PN} += "${datadir}/libframeworkd-phonegui-efl.${PN}"

inherit update-alternatives

ALTERNATIVE_NAME = "libframeworkd-phonegui-efl-theme"
ALTERNATIVE_LINK = "${datadir}/libframeworkd-phonegui-efl"
ALTERNATIVE_PATH = "${datadir}/libframeworkd-phonegui-efl.${PN}"
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
