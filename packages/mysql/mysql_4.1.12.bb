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

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/mysql-${PV}', '${FILE_DIRNAME}/mysql-4.1.10a', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

inherit autotools


EXTRA_OEMAKE = "'GEN_LEX_HASH=${STAGING_BINDIR}/gen_lex_hash'"
EXTRA_OECONF = " --with-embedded-server --prefix=/usr --sysconfdir=/etc/mysql --localstatedir=/var/mysql --datadir=/var/mysql --disable-dependency-tracking --without-raid --without-debug --with-low-memory --without-query-cache --without-man --without-docs --without-innodb "

do_stage() {
	autotools_stage_includes
	oe_libinstall -a -so -C libmysql libmysqlclient ${STAGING_LIBDIR}
	oe_libinstall -a -C libmysqld libmysqld ${STAGING_LIBDIR}
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	mv -f ${D}${libdir}/mysql/* ${D}${libdir}
	rmdir ${D}${libdir}/mysql
}

pkg_postinst () {
	grep mysql /etc/passwd || adduser --disabled-password --home=/var/mysql --ingroup nogroup mysql
}

pkg_postrm () {
	grep mysql /etc/passwd && deluser mysql
}

PACKAGES =+ "libmysqlclient libmysqlclient-dev"

FILES_libmysqlclient = "${libdir}/libmysqlclient*.so.*"
FILES_libmysqlclient-dev = "${incdir}/mysql ${libdir}/lib* \
                ${bindir}/mysql_config"

