DESCRIPTION = "Secure ftp daemon"
SECTION = "console/network"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.nl.uu.net/pub/unix/ftp/proftpd/ftp/distrib/source/${PN}-${PV}.tar.gz \
	file://make.patch \
	"
SRC_URI[md5sum] = "4f2c554d6273b8145095837913ba9e5d"
SRC_URI[sha256sum] = "44be095ed063df93278928cf665ad7b9b38e2c8d0cca97fb51307ec3a390a591"

EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes ac_cv_func_setgrent_void=yes --disable-cap"
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

pkg_postinst () {
	# more chown's might be needed
        chown root:root /usr/sbin/proftpd
}
