SECTION = "console/network"
DEPENDS = "openssl virtual/db"
DESCRIPTION = "Generic client/server library for SASL authentication."
LICENSE = "BSD"
PR = "r8"

SRC_URI = "ftp://ftp.andrew.cmu.edu/pub/cyrus-mail/cyrus-sasl-${PV}.tar.gz \
	   file://berkdb.m4.patch;patch=1"

inherit autotools 

acpaths = "-I ${S}/cmulocal -I ${S}/config -I ."
CFLAGS_append = " -I${S}/include -I${S}/saslauthd/include"
TARGET_LDFLAGS_append_thumb = " -lpthread"
EXTRA_OECONF = "--enable-shared --enable-static --with-dblib=berkeley \
	        --with-bdb-libdir=${STAGING_LIBDIR} \
	        --with-bdb-incdir=${STAGING_INCDIR} \
		--without-pam \
		--without-opie --without-des"

FILES_${PN} += "${prefix}/lib/sasl2/*.so*"
FILES_${PN}-dev += "${libdir}/sasl2/*.la ${libdir}/sasl2/*.a"

do_configure_prepend () {
	rm -f acinclude.m4 config/libtool.m4
}

do_compile_prepend () {
	cd include
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} makemd5.c -o makemd5
	touch makemd5.o makemd5.lo makemd5
	cd ..
}

pkg_postinst () {
        grep cyrus /etc/passwd || adduser --disabled-password --home=/var/spool/mail --ingroup mail -g "Cyrus sasl" cyrus
	echo "cyrus" | saslpasswd2 -p -c cyrus
	chgrp mail /etc/sasldb2
}
