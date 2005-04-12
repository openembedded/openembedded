DESCRIPTION = "The MySQL Open Source Database System"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "libs"
DEPENDS += "ncurses mysql-native"
PR = "r3"
LICENSE = "GPL"
SRC_URI = "http://mirrors.develooper.com/mysql/Downloads/MySQL-4.1/mysql-${PV}.tar.gz \
           file://autofoo.patch;patch=1 \
           file://gen_lex_hash.patch;patch=1"
S = "${WORKDIR}/mysql-${PV}"

inherit autotools

EXTRA_OEMAKE = "'GEN_LEX_HASH=${STAGING_BINDIR}/gen_lex_hash'"
EXTRA_OECONF = " --with-embedded-server "

do_stage() {
	autotools_stage_includes
	oe_libinstall -a -so -C libmysql libmysqlclient libmysqld ${STAGING_LIBDIR}
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	mv -f ${D}${libdir}/mysql/* ${D}${libdir}
	rmdir ${D}${libdir}/mysql
}

PACKAGES =+ "libmysqlclient libmysqlclient-dev"

FILES_libmysqlclient = "${libdir}/libmysqlclient*.so.*"
FILES_libmysqlclient-dev = "${incdir}/mysql ${libdir}/lib* \
                ${bindir}/mysql_config"

