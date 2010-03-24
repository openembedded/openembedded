DESCRIPTION = "Perl extensions for IPv6"
SECTION = "libs"
LICENSE = "BSD"
PR = "r0"

BBCLASSEXTEND = "native"

CFLAGS += "-D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"
BUILD_CFLAGS += "-D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/U/UM/UMEMOTO/Socket6-${PV}.tar.gz;name=socket6-perl-${PV}"
SRC_URI[socket6-perl-0.23.md5sum] = "2c02adb13c449d48d232bb704ddbd492"
SRC_URI[socket6-perl-0.23.sha256sum] = "eda753f0197e8c3c8d4ab20a634561ce84011fa51aa5ff40d4dbcb326ace0833"

S = "${WORKDIR}/Socket6-${PV}"

do_configure_prepend () {
	oenote Executing autoreconf --verbose --install --force
	mkdir -p m4
	autoreconf -Wcross --verbose --install --force || oefatal "autoreconf execution failed."
	sed -i 's:\./configure\(.[^-]\):./configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} --bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} --datadir=${datadir} --sysconfdir=${sysconfdir} --sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} --libdir=${libdir} --includedir=${includedir} --oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}\1:' Makefile.PL
}

inherit cpan
