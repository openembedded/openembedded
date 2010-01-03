DESCRIPTION = "Device::SerialPort - Linux/POSIX emulation of Win32::SerialPort functions."
SECTION = "libs"
LICENSE = "GPL"
RDEPENDS += "perl-module-carp perl-module-posix perl-module-io-handle \
	     perl-module-strict perl-module-warnings perl-module-vars \
	     perl-module-xsloader"
PR= "r1"

SRC_URI = "http://www.cpan.org/modules/by-module/Device/Device-SerialPort-${PV}.tar.gz"

S = "${WORKDIR}/Device-SerialPort-${PV}"

inherit cpan

# inspired by autotools.bbclass
do_configure_prepend () {
	oenote Executing autoreconf --verbose --install --force
	mkdir -p m4
	autoreconf -Wcross --verbose --install --force || oefatal "autoreconf execution failed."
	sed -i 's:\./configure\(.[^-]\):./configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} --bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} --datadir=${datadir} --sysconfdir=${sysconfdir} --sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} --libdir=${libdir} --includedir=${includedir} --oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}\1:' Makefile.PL
}

BBCLASSEXTEND="native"
