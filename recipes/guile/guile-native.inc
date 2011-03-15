SECTION = "unknown"
LICENSE = "LGPLv2.1"
DEPENDS = "gmp-native gettext-native"

inherit autotools native

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-Werror':'':g
}

