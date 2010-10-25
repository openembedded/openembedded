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

SRC_URI[md5sum] = "37b4479951fa0cf052269d27c41ca200"
SRC_URI[sha256sum] = "6bd2436fd0f233bb1518e15975cb4e9fa4434acb53c3c3cd7d4648219abf58e9"
