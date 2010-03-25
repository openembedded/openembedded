DESCRIPTION = "Perl module to manage IPv4 and IPv6 addresses and subnets"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libtest-pod-perl-native"
RDEPENDS_${PN} += "perl-module-test-more"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MI/MIKER/NetAddr-IP-${PV}.tar.gz;name=netaddr-ip-perl-${PV}"
SRC_URI[netaddr-ip-perl-4.027.md5sum] = "c4a21a76e5b1b9f4c8e9810b78559d7b"
SRC_URI[netaddr-ip-perl-4.027.sha256sum] = "e26b76d65e83841ba618bbe9ea913159e5e0e14a1e611b3ff870ed41e60077e0"

S = "${WORKDIR}/NetAddr-IP-${PV}"

inherit cpan

do_configure_prepend() {
	cd Lite/Util
	oenote Executing autoreconf --verbose --install --force
        mkdir -p m4
        autoreconf -Wcross --verbose --install --force || oefatal "autoreconf execution failed."
	./configure --build=${BUILD_SYS} --host=${HOST_SYS} \
		--target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} \
		--bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} \
		--datadir=${datadir} --sysconfdir=${sysconfdir} \
		--sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} \
		--libdir=${libdir} --includedir=${includedir} \
		--oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}
	cd ${S}
}
