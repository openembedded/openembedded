SECTION = "console/network"
DEPENDS = "cyrus-sasl virtual/db"
LICENSE = "BSD"
PR = "r8"
DEPENDS += "install-native"

SRC_URI = "ftp://ftp.andrew.cmu.edu/pub/cyrus-mail/cyrus-imapd-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
           file://tail.patch;patch=1 \
	   file://cyrus \
	   file://cyrus.conf_2.2 \
	   file://imapd.conf_2.2 \
	   file://volatiles \
	   "

inherit autotools update-rc.d

INITSCRIPT_NAME = "cyrus"
INITSCRIPT_PARAMS = "start 56 3 4 5 . stop 15 0 1 6 ."

TARGET_LDFLAGS_append_thumb = " -lpthread"
EXTRA_OECONF = "--with-auth=unix \
		--with-dblib=berkeley \
	        --with-bdb-libdir=${STAGING_LIBDIR} \
	        --with-bdb-incdir=${STAGING_INCDIR} \
		--without-perl \
		--without-snmp"

FILES_${PN} += "${prefix}/cyrus/bin"

# All, lib/foo.c includes <config.h> from the top level directory and
# is natively compiled
BUILD_CPPFLAGS += " -I${S} -I${S}/et"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/cyrus ${D}${sysconfdir}/init.d/cyrus
	install -m 644 ${WORKDIR}/cyrus.conf_2.2 ${D}${sysconfdir}/cyrus.conf
	install -m 644 ${WORKDIR}/imapd.conf_2.2 ${D}${sysconfdir}/imapd.conf
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/01_cyrus-imapd
}

pkg_postinst () {
	/etc/init.d/populate-volatile.sh
}

pkg_postrm () {
}

