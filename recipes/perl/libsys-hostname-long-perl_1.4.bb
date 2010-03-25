DESCRIPTION = "Sys::Hostname::Long - Try every conceivable way to get full hostname"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SC/SCOTT/Sys-Hostname-Long-${PV}.tar.gz;name=sys-hostname-long-perl-${PV}"
SRC_URI[sys-hostname-long-perl-1.4.md5sum] = "a5b3c23754cbcff10e283d16c42ec3d3"
SRC_URI[sys-hostname-long-perl-1.4.sha256sum] = "9db6c8cd3ca0ba8dbf19969ed0a936cecb7f555c1cc8077b08cf8bf78b10c143"

S = "${WORKDIR}/Sys-Hostname-Long-${PV}"

inherit cpan

do_configure_prepend () {
	# Busybox compatibility
	sed -ri "s,hostname\ --fqdn,hostname -f," lib/Sys/Hostname/Long.pm
}

PACKAGE_ARCH = "all"
