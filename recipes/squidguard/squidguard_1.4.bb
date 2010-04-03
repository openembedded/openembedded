DESCRIPTION = "Squid URL redirector"
HOMEPAGE = "http://www.squidguard.org/"
SECTION = "network"
DEPENDS = "virtual/db openldap mysql5 zlib"
RDEPENDS += "squid"
LICENSE = "GPL"
PR = "r0"

SRC_URI = " \
	http://www.squidguard.org/Downloads/squidGuard-${PV}.tar.gz;name=tar \
	file://squidguard-1.4-no_header_checks.patch;patch=1 \
	file://squidguard-1.4-fix-parallel-build.patch;patch=1 \
	file://squidguard-cross-ldap.patch;patch=1 \
	file://squidGuard.conf \
	"
SRC_URI[tar.md5sum] = "de834150998c1386c30feae196f16b06"
SRC_URI[tar.sha256sum] = "0711ce60b8e2bbba107b980fed446a88df35e1584b39f079c0cae54a172c5141"

S = "${WORKDIR}/squidGuard-${PV}"

EXTRA_OECONF += " \
	--with-squiduser=nobody \
	--with-db=${STAGING_INCDIR}/.. \
	--with-sg-config=${sysconfdir}/squid/squidGuard.conf \
	--with-sg-logdir=${localstatedir}/log/squid \
	--with-sg-dbhome=${localstatedir}/lib/squidguard/db \
	--with-ldap=yes \
	--with-mysql=${STAGING_INCDIR}/.. \
	"

inherit autotools

do_configure_prepend() {
	export ac_cv_header_db_h=yes 
	export db_ok_version=yes
	export dbg3_ok_version=yes
	export dbg2_ok_version=yes
	cp src/config.h.in src/config.h.in.original
}

do_configure_append() {
	mv src/config.h.in.original src/config.h.in
	./config.status
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}/squid
	install -d ${D}${localstatedir}/log/squid
	install -d ${D}${localstatedir}/lib/squidguard/db
	install -m 0755 src/squidGuard ${D}${bindir}
	install -m 0644 ${WORKDIR}/squidGuard.conf ${D}${sysconfdir}/squid/squidGuard.conf
}
