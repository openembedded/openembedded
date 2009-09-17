SECTION = "e/utils"
DEPENDS += "edje-native"

FILES_${PN} += "${datadir}/libframeworkd-phonegui-efl.${PN}"

inherit update-alternatives

ALTERNATIVE_NAME = "libframeworkd-phonegui-efl-theme"
ALTERNATIVE_LINK = "${datadir}/libframeworkd-phonegui-efl"
ALTERNATIVE_PATH = "${datadir}/libframeworkd-phonegui-efl.${PN}"
ALTERNATIVE_PRIORITY ?= 1

pkg_postinst() {
        if [[ -e /usr/share/libframeworkd-phonegui-efl && ! -h /usr/share/libframeworkd-phonegui-efl ]] ; then
                echo "Removing old /usr/share/libframeworkd-phonegui-efl directory. Will be replaced with link managed by update-alternatives"
                echo "Press enter to continue"
                read
                rm -rf /usr/share/libframeworkd-phonegui-efl
        fi
}
