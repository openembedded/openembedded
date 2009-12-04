DESCRIPTION = "The MySQL Open Source Database System"
HOMEPAGE = "http://www.mysql.com/"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "ncurses"
PR = "r6"

SRC_URI = "http://downloads.mysql.com/archives/mysql-4.1/mysql-${PV}.tar.gz \
           file://autofoo.patch;patch=1 \
           file://fix_host_path.patch;patch=1 \
	   file://configure-ps-cache-check.patch;patch=1 \
           file://my.cnf \
           file://mysqld.sh"

S = "${WORKDIR}/mysql-${PV}"

BINCONFIG_GLOB = "mysql_config"

inherit autotools binconfig update-rc.d

INITSCRIPT_PACKAGES = "mysql-server"
INITSCRIPT_NAME = "mysqld"
INITSCRIPT_PARAMS = "start 45 S . stop 45 0 6 1 ."

export ac_cv_path_PS=/bin/ps
export ac_cv_FIND_PROC="/bin/ps p \$\$PID | grep -v grep | grep mysqld > /dev/null"
PARALLEL_MAKE = " "
#EXTRA_OEMAKE = "'GEN_LEX_HASH=${STAGING_BINDIR_NATIVE}/gen_lex_hash'"
EXTRA_OECONF = " --with-embedded-server --prefix=/usr --sysconfdir=/etc/mysql --localstatedir=/var/mysql --datadir=/var/mysql --disable-dependency-tracking --without-raid --without-debug --with-low-memory --without-query-cache --without-man --without-docs --without-innodb "

do_configure_append() {
     sed -i /comp_err/d ${S}/sql/share/Makefile
}

do_stage() {
	autotools_stage_all
	oe_libinstall -a -so -C libmysql libmysqlclient ${STAGING_LIBDIR}
	oe_libinstall -a -C libmysqld libmysqld ${STAGING_LIBDIR}
}

SYSROOT_PREPROCESS_FUNCS += "mysqlmangle"

mysqlmangle() {
	sed -i -es,^pkgincludedir=\'/usr/include/mysql\',pkgincludedir=\'${STAGING_INCDIR}\', ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/mysql_config
	sed -i -es,^pkglibdir=\'/usr/lib/mysql\',pkglibdir=\'${STAGING_LIBDIR}\', ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/mysql_config
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	mv -f ${D}${libdir}/mysql/* ${D}${libdir}
	rmdir ${D}${libdir}/mysql

	install -d ${D}/etc/init.d
	install -m 0644 ${WORKDIR}/my.cnf ${D}/etc/
	install -m 0755 ${WORKDIR}/mysqld.sh ${D}/etc/init.d/mysqld
}

pkg_postinst_mysql-server () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi

	grep mysql /etc/passwd || adduser --disabled-password --home=/var/mysql --ingroup nogroup mysql

	#Install the database
	test -d /usr/bin || mkdir -p /usr/bin
	test -e /usr/bin/hostname || ln -s /bin/hostname /usr/bin/hostname
	mkdir /var/lib/mysql
	chown mysql.nogroup /var/lib/mysql

	mysql_install_db

}

pkg_postrm_mysql-server () {
	grep mysql /etc/passwd && deluser mysql
}

PACKAGES = "${PN}-dbg ${PN} libmysqlclient libmysqlclient-dev mysql-client mysql-server ${PN}-leftovers"
CONFFILES_mysql-server = "${sysconfdir}/my.cnf"

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
${localstatedir}/mysql/ \
${sysconfdir}/init.d \
${sysconfdir}/my.cnf"

DESCRIPTION_${PN}-leftovers = "unpackaged and probably unneeded files for ${PN}"
FILES_${PN}-leftovers = "/"
