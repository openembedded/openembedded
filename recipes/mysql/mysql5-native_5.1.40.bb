require mysql5_${PV}.inc
inherit native
PR ="r0"

SRC_URI = "http://downloads.mysql.com/archives/mysql-5.1/mysql-${PV}.tar.gz"

RDEPENDS_${PN} = ""
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


# Mysql tries to access the ${WORKDIR} from this build..
do_rm_work() {
       :
}
