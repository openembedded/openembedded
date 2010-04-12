DESCRIPTION = "The SSH library is a C library to authenticate in a \
simple manner to one or more SSH servers. The goal of this project \
is to provide a library much simpler to use than OpenSSHs one. It \
includes SFTP support, and a sample SSH client is provided."
HOMEPAGE = "http://0xbadc0de.be/wiki/libssh:libssh"
LICENSE = "LGPL"
SECTION = "libs"
DEPENDS = "openssl"

SRC_URI = "\
  http://www.0xbadc0de.be/libssh/libssh-${PV}.tgz \
  file://libssh_libdir_fix.patch;patch=1 \
"
inherit autotools

EXTRA_OECONF = "--cache-file=${S}/config.cache"

do_compile () {
	oenote make "$@"
	make "$@" || die "oe_runmake failed"
}

do_stage () {
	install -d ${STAGING_INCDIR}/libssh
	for i in crypto.h libssh.h sftp.h ssh2.h; do
		install -m 0644 ${S}/include/libssh/$i ${STAGING_INCDIR}/libssh/
	done
	oe_libinstall -so -C libssh libssh ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "8a76c03579a3e27046e6bafe88ffd171"
SRC_URI[sha256sum] = "46c3831fd563c54283ebef56e2cb11c27f47b1be9f6cb44f1465897dd7aea5ff"
