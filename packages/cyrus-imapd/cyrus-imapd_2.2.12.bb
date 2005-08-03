SECTION = "console/network"
DEPENDS = "cyrus-sasl db3"
LICENSE = "BSD"
PR = "r5"
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

EXTRA_OECONF = "--with-auth=unix \
		--without-perl \
		--without-snmp"

FILES_${PN} += "${prefix}/cyrus/bin"

# Target only, the db4 headers are in include/db4, so *prepend* this
# directory to the search path
TARGET_CPPFLAGS =+ "-I${STAGING_DIR}/${TARGET_SYS}/include/db4"

# All, lib/foo.c includes <config.h> from the top level directory and
# is natively compiled
BUILD_CPPFLAGS += " -I${S} -I${S}/et"

do_install_append () {
	install -m 755 ${WORKDIR}/cyrus ${D}${sysconfdir}/init.d/cyrus
	install -m 644 ${WORKDIR}/cyrus.conf_2.2 ${D}${sysconfdir}/cyrus.conf
	install -m 644 ${WORKDIR}/imapd.conf_2.2 ${D}${sysconfdir}/imapd.conf
	install -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/01_cyrus-imapd
}

pkg_postinst () {
	/etc/init.d/populate-volatile.sh
}

pkg_postrm () {
}

