SECTION = "console/network"
include mysql_${PV}.bb
inherit native

PACKAGES = ""
DEPENDS = "ncurses-native"
EXTRA_OEMAKE = ""
EXTRA_OECONF = " --with-embedded-server "

do_stage() {
	install -m 0755 sql/gen_lex_hash ${STAGING_BINDIR}/
}

do_install() {
	:
}
