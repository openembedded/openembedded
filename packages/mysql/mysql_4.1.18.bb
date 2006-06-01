DESCRIPTION = "The MySQL Open Source Database System"
SECTION = "libs"
HOMEPAGE = "http://www.mysql.com/"
DEPENDS += "ncurses mysql-native"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://mirrors.develooper.com/mysql/Downloads/MySQL-4.1/mysql-${PV}.tar.gz \
           file://autofoo.patch;patch=1 \
	   file://gen_lex_hash.patch;patch=1"

S = "${WORKDIR}/mysql-${PV}"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/mysql-${PV}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

BINCONFIG_GLOB = "mysql_config"
inherit autotools binconfig


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

PACKAGES = "${PN} libmysqlclient libmysqlclient-dev mysql-client mysql-server"

FILES_${PN} = " "
RDEPENDS_${PN} = "mysql-client mysql-server"
ALLOW_EMPTY_${PN} = "1"

FILES_libmysqlclient = "${libdir}/libmysqlclient*.so.*"
FILES_libmysqlclient-dev = "${includedir}/mysql/ ${libdir}/lib* ${bindir}/mysql_config"

FILES_mysql-client = "\
${bindir}/myisam_ftdump \
${bindir}/mysql \
${bindir}/mysql_explain_log \
${bindir}/mysql_find_rows \
${bindir}/mysql_fix_extensions \
${bindir}/mysql_tableinfo \
${bindir}/mysql_waitpid \
${bindir}/mysqlaccess \
${bindir}/mysqladmin \
${bindir}/mysqlbug \
${bindir}/mysqlcheck \
${bindir}/mysqldump \
${bindir}/mysqldumpslow \
${bindir}/mysqlimport \
${bindir}/mysqlmanager \
${bindir}/mysqlmanager-pwgen \
${bindir}/mysqlmanagerc \
${bindir}/mysqlshow"

FILES_mysql-server = "\
${bindir}/comp_err \
${bindir}/isamchk \
${bindir}/isamlog \
${bindir}/msql2mysql \
${bindir}/myisamchk \
${bindir}/myisamlog \
${bindir}/myisampack \
${bindir}/my_print_defaults \
${bindir}/mysqlbinlog \
${bindir}/mysql_convert_table_format \
${bindir}/mysql_create_system_tables \
${bindir}/mysqld_multi \
${bindir}/mysqld_safe \
${bindir}/mysql_fix_privilege_tables \
${bindir}/mysqlhotcopy \
${bindir}/mysql_install_db \
${bindir}/mysql_secure_installation \
${bindir}/mysql_setpermission \
${bindir}/mysqltest \
${bindir}/mysql_tzinfo_to_sql \
${bindir}/mysql_zap \
${bindir}/pack_isam \
${bindir}/perror \
${bindir}/replace \
${bindir}/resolveip \
${bindir}/resolve_stack_dump \
${bindir}/ndb_delete_all \
${bindir}/ndb_mgm \
${bindir}/ndb_show_tables \
${bindir}/ndb_desc \
${bindir}/ndb_restore \
${bindir}/ndb_waiter \
${bindir}/ndb_drop_index \
${bindir}/ndb_select_all \
${bindir}/ndb_drop_table \
${bindir}/ndb_select_count \
${libexecdir}/mysqld \
${sbindir}/mysqld \
${sbindir}/ndb_cpcd \
${sbindir}/ndbd \
${sbindir}/ndb_mgmd \
${datadir}/mysql/ \
${localstatedir}/mysql/"
