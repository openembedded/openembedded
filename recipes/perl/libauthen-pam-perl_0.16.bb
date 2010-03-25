DESCRIPTION = "Authen::PAM - Perl interface to PAM library"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libpam"
RDEPENDS = "perl-module-posix"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/N/NI/NIKIP/Authen-PAM-${PV}.tar.gz;name=authen-pam-perl-${PV}"
SRC_URI[authen-pam-perl-0.16.md5sum] = "7278471dfa694d9ef312bc92d7099af2"
SRC_URI[authen-pam-perl-0.16.sha256sum] = "0e949bd9a2a9df0f829971030fe9169cbaf6cec78b92faf22f547ff6c6155c9b"

S = "${WORKDIR}/Authen-PAM-${PV}"

do_configure_prepend () {
	oenote Executing autoreconf --verbose --install --force
	mkdir -p m4
	autoreconf -Wcross --verbose --install --force || oefatal "autoreconf execution failed."
	sed -i 's:\./configure\(.[^-]\):./configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} --bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} --datadir=${datadir} --sysconfdir=${sysconfdir} --sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} --libdir=${libdir} --includedir=${includedir} --oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}\1:' Makefile.PL
}

inherit cpan
