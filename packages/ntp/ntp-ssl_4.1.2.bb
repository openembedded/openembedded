DESCRIPTION = "The Network Time Protocol (NTP) is used to \
synchronize the time of a computer client or server to \
another server or reference time source, such as a radio \
or satellite receiver or modem."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "openssl"
LICENSE = "NTP"
PR = "r1"

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://readline.patch;patch=1 \
	   file://ntpdate"
S = "${WORKDIR}/ntp-${PV}"

inherit autotools

EXTRA_OECONF = "--with-openssl-libdir=${STAGING_LIBDIR} \
	        --with-openssl-incdir=${STAGING_INCDIR}/openssl"
CFLAGS_append = " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"

PACKAGES = "ntpdate ntp"

FILES_ntpdate = "${bindir}/ntpdate /etc/init.d/ntpdate"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ntpdate ${D}${sysconfdir}/init.d
}
