# OpenLDAP, a license free (see http://www.OpenLDAP.org/license.html)
#
DESCRIPTION = "OpenLDAP Software is an open source implementation of the Lightweight Directory Access Protocol."
HOMEPAGE = "http://www.OpenLDAP.org/license.html"
PRIORITY = "optional"
# The OpenLDAP Public License - see the HOMEPAGE - defines
# the license.  www.openldap.org claims this is Open Source
# (see http://www.openldap.org), the license appears to be
# basically BSD.  opensource.org does not record this license
# at present (so it is apparently not OSI certified).
LICENSE = "OpenLDAP"
SECTION = "libs"

LDAP_VER = "${@'.'.join(bb.data.getVar('PV',d,1).split('.')[0:2])}"

SRC_URI = "ftp://ftp.openldap.org/pub/OpenLDAP/openldap-release/${P}.tgz;name=openldap-${PV}"
SRC_URI += "file://openldap-m4-pthread.patch;patch=1"
SRC_URI += "file://initscript"
SRC_URI[openldap-2.4.21.md5sum] = "e7128c57b2bacd940e8906057c94ff26"
SRC_URI[openldap-2.4.21.sha256sum] = "22eca357137c135b5561e2fa0e3336b280702acf2e5c4f40bc7aed1d1e8e9324"
# The build tries to run a host executable, this fails.  The patch
# causes the executable and its data to be installed instead of
# the output - ucgendat must be run after the ipkg install!
#SRC_URI += "file://ucgendat.patch;patch=1"
# The original top.mk used INSTALL, not INSTALL_STRIP_PROGRAM when
# installing .so and executables, this fails in cross compilation
# environments
SRC_URI += "file://install-strip.patch;patch=1"

inherit autotools

# OPTIONS
# The following two variables can be set in a distro or local.conf
# to switch features on.  Each feature foo defines OPENLDAP_OPTION_foo
# and OPENLDAP_DEPENDS_foo in this file - to include feature foo add
# the two variables into the setting of the options below (please use
# += because that means this can be done in *both* distro.conf and
# local.conf!
OPENLDAP_OPTIONS ?= ""
OPENLDAP_DEPENDS ?= ""

# CV SETTINGS
# Required to work round AC_FUNC_MEMCMP which gets the wrong answer
# when cross compiling (should be in site?)
EXTRA_OECONF += "ac_cv_func_memcmp_working=yes"

# CONFIG DEFINITIONS
# The following is necessary because it cannot be determined for a
# cross compile automagically.  Select should yield fine on all OE
# systems...
EXTRA_OECONF += "--with-yielding-select=yes"
# Shared libraries are nice...
EXTRA_OECONF += "--enable-dynamic"
#
# Disable TLS to remove the need for openssl/libcrypto
OPENLDAP_OPTION_tls  ?= "--with-tls"
# set the following to "openssl" to build tls support
OPENLDAP_DEPENDS_tls ?= "gnutls"
EXTRA_OECONF += "${OPENLDAP_OPTION_tls}"
DEPENDS += "${OPENLDAP_DEPENDS_tls}"
#
# Disable Cyrus SASL, which may or may not be working at present...
OPENLDAP_OPTION_sasl  ?= "--without-cyrus-sasl"
# set the following to "cyrus-sasl" to build SASL support
OPENLDAP_DEPENDS_sasl ?= ""
EXTRA_OECONF += "${OPENLDAP_OPTION_sasl}"
DEPENDS += "${OPENLDAP_DEPENDS_sasl}"

# SLAPD options
#
# UNIX crypt(3) passwd support:
EXTRA_OECONF += "--enable-crypt"
#
# Enable dynamic module loading.  If this is *disabled* the
# dependency on libtool is removed (to disable set the following
# to variables to "" in a .conf file).
OPENLDAP_OPTION_modules += "lt_cv_dlopen_self=yes --enable-modules"
OPENLDAP_DEPENDS_modules += "libtool"
EXTRA_OECONF += " ${OPENLDAP_OPTION_modules}"
DEPENDS += "${OPENLDAP_DEPENDS_modules}"

# SLAPD BACKEND
#
# The backend must be set by the configuration.  This controls the
# required database, the default database, bdb, is turned off but
# can be turned back on again and it *is* below!  The monitor backend
# is also disabled.  If you try to change the backends but fail to
# enable a single one the build will fail in an obvious way.
#
EXTRA_OECONF += "--disable-bdb --disable-hdb --disable-monitor"
#
# Backends="bdb dnssrv hdb ldap ldbm meta monitor null passwd perl shell sql"
#
# Note that multiple backends can be built.  The ldbm backend requires a
# build-time choice of database API.  The bdb backend forces this to be
# DB4.  To use the gdbm (or other) API the Berkely database module must
# be removed from the build.
md = "${libexecdir}/openldap"
#
#--enable-bdb          enable Berkeley DB backend no|yes|mod yes
# The Berkely DB is the standard choice.  This version of OpenLDAP requires
# the version 4 implementation or better.
# To disable this set all three of the following variables to <empty> in
# a .conf file (this will allow ldbm to be build with gdbm).
#OPENLDAP_OPTION_bdb   ?= "--enable-bdb=mod"
OPENLDAP_DEPENDS_bdb  ?= "db"
OPENLDAP_PACKAGE_bdb  ?= "${PN}-backend-bdb"
FILES_${PN}-backend-bdb = "${md}/back_bdb.so ${md}/back_bdb.la ${md}/back_bdb-*.so.*"
EXTRA_OECONF += "${OPENLDAP_OPTION_bdb}"
DEPENDS += "${OPENLDAP_DEPENDS_bdb}"
PACKAGES += "${OPENLDAP_PACKAGE_bdb}"
#
#--enable-dnssrv       enable dnssrv backend no|yes|mod no
# This has no dependencies.
FILES_${PN}-backend-dnssrv = "${md}/back_dnssrv.so ${md}/back_dnssrv.la ${md}/back_dnssrv-*.so.*"
EXTRA_OECONF += "--enable-dnssrv=mod"
PACKAGES += "${PN}-backend-dnssrv"
#
#--enable-hdb          enable Hierarchical DB backend no|yes|mod no
# This forces ldbm to use Berkeley too, remove to use gdbm
#OPENLDAP_OPTION_hdb   ?= "--enable-hdb=mod"
OPENLDAP_DEPENDS_hdb  ?= "db"
OPENLDAP_PACKAGE_hdb  ?= "${PN}-backend-hdb"
FILES_${PN}-backend-hdb = "${md}/back_hdb.so ${md}/back_hdb.la ${md}/back_hdb-*.so.*"
EXTRA_OECONF += "${OPENLDAP_OPTION_hdb}"
DEPENDS += "${OPENLDAP_DEPENDS_hdb}"
PACKAGES += "${OPENLDAP_PACKAGE_hdb}"
#
#--enable-ldap         enable ldap backend no|yes|mod no
# This has no dependencies
EXTRA_OECONF += "--enable-ldap=mod"
FILES_${PN}-backend-ldap = "${md}/back_ldap.so ${md}/back_ldap.la ${md}/back_ldap-*.so.*"
PACKAGES += "${PN}-backend-ldap"
#
#--enable-ldbm         enable ldbm backend no|yes|mod no
# ldbm requires further specification of the underlying database API, because
# bdb is enabled above this must be set to berkeley, however the config
# defaults this correctly so --with-ldbm-api is *not* set.  The build will
# fail if bdb is removed (above) but not database is built to provide the
# support for ldbm (because the 'DEPENDS_ldbm' is empty below.)
#
# So to use gdbm set:
OPENLDAP_OPTION_ldbm = "--enable-ldbm=mod --with-ldbm-api=gdbm"
OPENLDAP_DEPENDS_ldbm = gdbm
# And clear the bdb and hdb settings.
OPENLDAP_OPTION_ldbm ?= "--enable-ldbm=mod"
OPENLDAP_DEPENDS_ldbm ?= ""
OPENLDAP_PACKAGES_ldbm ?= "${PN}-backend-ldbm"
FILES_${PN}-backend-ldbm = "${md}/back_ldbm.so ${md}/back_ldbm.la ${md}/back_ldbm-*.so.*"
EXTRA_OECONF += "${OPENLDAP_OPTION_ldbm}"
DEPENDS += "${OPENLDAP_DEPENDS_ldbm}"
PACKAGES += "${PN}-backend-ldbm"
#
#--enable-meta         enable metadirectory backend no|yes|mod no
# No dependencies
EXTRA_OECONF += "--enable-meta=mod"
FILES_${PN}-backend-meta = "${md}/back_meta.so ${md}/back_meta.la ${md}/back_meta-*.so.*"
PACKAGES += "${PN}-backend-meta"
#
#--enable-monitor      enable monitor backend no|yes|mod yes
EXTRA_OECONF += "--enable-monitor=mod"
FILES_${PN}-backend-monitor = "${md}/back_monitor.so ${md}/back_monitor.la ${md}/back_monitor-*.so.*"
PACKAGES += "${PN}-backend-monitor"
#
#--enable-null         enable null backend no|yes|mod no
EXTRA_OECONF += "--enable-null=mod"
FILES_${PN}-backend-null = "${md}/back_null.so ${md}/back_null.la ${md}/back_null-*.so.*"
PACKAGES += "${PN}-backend-null"
#
#--enable-passwd       enable passwd backend no|yes|mod no
EXTRA_OECONF += " --enable-passwd=mod"
FILES_${PN}-backend-passwd = "${md}/back_passwd.so ${md}/back_passwd.la ${md}/back_passwd-*.so.*"
PACKAGES += "${PN}-backend-passwd"
#
#--enable-perl         enable perl backend no|yes|mod no
#  This requires a loadable perl dynamic library, if enabled without
#  doing something appropriate (building perl?) the build will pick
#  up the build machine perl - not good.
OPENLDAP_OPTION_perl ?= "--enable-perl=mod"
OPENLDAP_DEPENDS_perl ?= "perl"
OPENLDAP_PACKAGES_perl ?= "${PN}-backend-perl"
FILES_${PN}-backend-perl = "${md}/back_perl.so ${md}/back_perl.la ${md}/back_perl-*.so.*"
#EXTRA_OECONF += "${OPENLDAP_OPTION_perl}"
#DEPENDS += "${OPENLDAP_DEPENDS_perl}"
#PACKAGES += "${PN}-backend-perl"
#
#--enable-shell        enable shell backend no|yes|mod no
EXTRA_OECONF += "--enable-shell=mod"
FILES_${PN}-backend-shell = "${md}/back_shell.so ${md}/back_shell.la ${md}/back_shell-*.so.*"
PACKAGES += "${PN}-backend-shell"
#
#--enable-sql          enable sql backend no|yes|mod no
# sql requires some sql backend which provides sql.h, sqlite* provides
# sqlite.h (which may be compatible but hasn't been tried.)
OPENLDAP_OPTION_sql ?= "--enable-sql=mod"
OPENLDAP_DEPENDS_sql ?= "sql"
OPENLDAP_PACKAGES_sql ?= "${PN}-backend-sql"
FILES_${PN}-backend-sql = "${md}/back_sql.so ${md}/back_sql.la ${md}/back_sql-*.so.*"
#EXTRA_OECONF += "${OPENLDAP_OPTION_sql}"
#DEPENDS += "${OPENLDAP_DEPENDS_sql}"
#PACKAGES += "${PN}-backend-sql"
#
#--enable-dyngroup     Dynamic Group overlay no|yes|mod no
#  This is a demo, Proxy Cache defines init_module which conflicts with the
#  same symbol in dyngroup
#EXTRA_OECONF += "--enable-dyngroup=mod"
#FILES_${PN}-overlay-dyngroup = "${md}/back_dyngroup.so ${md}/back_dyngroup.la ${md}/back_dyngroup-*.so.*"
#PACKAGES += "${PN}-overlay-dyngroup"
#
#--enable-proxycache   Proxy Cache overlay no|yes|mod no
EXTRA_OECONF += "--enable-proxycache=mod"
FILES_${PN}-overlay-proxycache = "${md}/pcache.so ${md}/pcache.la ${md}/pcache-*.so.*"
PACKAGES += "${PN}-overlay-proxycache"
#
# LOCAL OPTION OVERRIDES
# The distro/lcoal options must be added in *last*
EXTRA_OECONF += "${OPENLDAP_OPTIONS}"
DEPENDS      += "${OPENLDAP_DEPENDS}"

CPPFLAGS_append = " -D_GNU_SOURCE"

do_configure() {
	gnu-configize
	oe_runconf
}

#FIXME: this is a hack, at present an openldap build will pick up the header
# files from staging rather than the local ones (bad -I order), so remove
# the headers (from openldap-old.x) before compiling...
do_compile_prepend() {
	(	cd ${STAGING_INCDIR}
		rm -f ldap.h ldap_*.h
	)
	(	cd ${STAGING_LIBDIR}
		rm -f libldap* liblber*
	)
}

do_stage() {
	echo "staging libldap-${LDAP_VER}" >&2
	#
	autotools_stage_includes
	# Install the -${LDAP_VER} versions, but link foo.so to foo-x.y.so ONLY
	# if they do not exist!
	oe_libinstall -so -C libraries/libldap/.libs libldap-${LDAP_VER} ${STAGING_LIBDIR}
	test -e ${STAGING_LIBDIR}/libldap.so ||
		ln -s $(basename ${STAGING_LIBDIR}/libldap-${LDAP_VER}.so.*.*.*) ${STAGING_LIBDIR}/libldap.so
	oe_libinstall -so -C libraries/libldap_r/.libs libldap_r-${LDAP_VER} ${STAGING_LIBDIR}
	test -e ${STAGING_LIBDIR}/libldap_r.so ||
		ln -s $(basename ${STAGING_LIBDIR}/libldap_r-${LDAP_VER}.so.*.*.*) ${STAGING_LIBDIR}/libldap_r.so
	oe_libinstall -so -C libraries/liblber/.libs liblber-${LDAP_VER} ${STAGING_LIBDIR}
	test -e ${STAGING_LIBDIR}/liblber.so ||
		ln -s $(basename ${STAGING_LIBDIR}/liblber-${LDAP_VER}.so.*.*.*) ${STAGING_LIBDIR}/liblber.so
}

LEAD_SONAME = "libldap-${LDAP_VER}.so.*"

# The executables go in a separate package.  This allows the
# installation of the libraries with no daemon support.
# Each module also has its own package - see above.
PACKAGES += "${PN}-slapd ${PN}-slurpd ${PN}-bin"

# Package contents - shift most standard contents to -bin
FILES_${PN} = "${libdir}/lib*.so.* ${sysconfdir}/openldap/ldap.* ${localstatedir}/openldap-data"
FILES_${PN}-slapd = "${sysconfdir}/init.d ${libexecdir}/slapd ${sbindir} ${localstatedir}/run \
	${sysconfdir}/openldap/slapd.* ${sysconfdir}/openldap/schema \
	${sysconfdir}/openldap/DB_CONFIG.example"
FILES_${PN}-slurpd = "${libexecdir}/slurpd ${localstatedir}/openldap-slurp ${localstatedir}/run"
FILES_${PN}-bin = "${bindir}"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*.so ${libdir}/*.la ${libdir}/*.a ${libexecdir}/openldap/*.a"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	cat ${WORKDIR}/initscript > ${D}${sysconfdir}/init.d/openldap
	chmod 755 ${D}${sysconfdir}/init.d/openldap
	# This is duplicated in /etc/openldap and is for slapd
	rm -f ${D}${localstatedir}/openldap-data/DB_CONFIG.example
}

pkg_postinst_${PN}-slapd () {
        if test -n "${D}"; then
                D="-r $D"
        fi
        update-rc.d $D openldap defaults
}

pkg_prerm_${PN}-slapd () {
        if test -n "${D}"; then
                D="-r $D"
        fi
        update-rc.d $D openldap remove
}
