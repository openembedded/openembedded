SECTION = "unknown"
LICENSE = "LGPLv2.1"
DEPENDS = "gmp-native"

inherit autotools native gettext

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-Werror':'':g
}

