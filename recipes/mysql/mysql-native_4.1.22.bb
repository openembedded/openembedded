require mysql_${PV}.bb
inherit native
PR ="r0"

SRC_URI = "http://downloads.mysql.com/archives/mysql-4.1/mysql-${PV}.tar.gz"

RDEPENDS_${PN} = ""
PACKAGES = ""
DEPENDS = "ncurses-native"
EXTRA_OEMAKE = ""
EXTRA_OECONF = " --with-embedded-server "

do_install() {
	:
}


# Mysql tries to access the ${WORKDIR} from this build..
do_rm_work() {
       :
}
