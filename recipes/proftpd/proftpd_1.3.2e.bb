DESCRIPTION = "Secure ftp daemon"
SECTION = "console/network"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.nl.uu.net/pub/unix/ftp/proftpd/ftp/distrib/source/${PN}-${PV}.tar.gz;name=src \
	file://make.patch;patch=1 \
	"
SRC_URI[src.md5sum] = "4ecb82cb1050c0e897d5343f6d2cc1ed"
SRC_URI[src.sha256sum] = "7c7f295944e8e7c85060829deeaed74f3f0b36c8f1d3936277d59bbea5d60093"



EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes ac_cv_func_setgrent_void=yes"
LDFLAGS += "-Llib"
PARALLEL_MAKE = ""

do_configure () {
	 ./configure \
		   --disable-auth-pam \
                   --build=${BUILD_SYS} \
                   --host=${HOST_SYS} \
                   --target=${TARGET_SYS} \
                   --prefix=/usr \
		   --sysconfdir=/etc \
		   --sharedstatedir=/com \
		   --localstatedir=/var \
                   ${EXTRA_OECONF} \
                   $@;
}

do_install () {
	oe_runmake DESTDIR=${D} install
}

pkg_postinst () {
	# more chown's might be needed
        chown root:root /usr/sbin/proftpd
}
