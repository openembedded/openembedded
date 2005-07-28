SECTION = "libs"
DESCRIPTION = "The SSH library is a C library to authenticate in a \
simple manner to one or more SSH servers. The goal of this project \
is to provide a library much simpler to use than OpenSSHs one. It \
includes SFTP support, and a sample SSH client is provided."
DEPENDS = "openssl"
LICENSE = "LGPL"

SRC_URI = "http://www.0xbadc0de.be/libssh/libssh-${PV}.tgz"

inherit autotools

EXTRA_OECONF = "--cache-file=${S}/config.cache"

do_stage () {
	set -x
	install -d ${STAGING_INCDIR}/libssh
	for i in crypto.h libssh.h sftp.h ssh2.h; do
		install -m 0644 ${S}/include/libssh/$i ${STAGING_INCDIR}/libssh/
	done
	oe_libinstall -so -C libssh libssh ${STAGING_LIBDIR}
}

do_install () {
	oe_runmake "prefix=${D}${prefix}" \
		   "exec_prefix=${D}${exec_prefix}" \
		   "bindir=${D}${bindir}" \
		   "incldir=${D}${includedir}" \
		   "infodir=${D}${infodir}" \
		   "mandir=${D}${mandir}/man1" \
		   "libdir=${D}${libdir}" \
		   install
}
