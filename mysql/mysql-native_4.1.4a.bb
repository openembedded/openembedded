SECTION = "console/network"
include mysql_${PV}.bb
inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/mysql-${PV}', '${FILE_DIRNAME}/mysql-4.1', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""
DEPENDS = "ncurses-native"
EXTRA_OEMAKE = ""

do_stage() {
	install -m 0755 sql/gen_lex_hash ${STAGING_BINDIR}/
}

do_install() {
	:
}
