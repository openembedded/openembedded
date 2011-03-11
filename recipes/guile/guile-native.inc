SECTION = "unknown"
LICENSE = "LGPLv2.1"
DEPENDS = "gmp-native"

inherit autotools gettext native

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-Werror':'':g
}

