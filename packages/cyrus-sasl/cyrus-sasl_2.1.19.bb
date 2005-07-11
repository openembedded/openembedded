SECTION = "console/network"
DEPENDS = "db openssl"
DESCRIPTION = "Generic client/server library for SASL authentication."
LICENSE = "BSD"
PR = "r2"

SRC_URI = "ftp://ftp.andrew.cmu.edu/pub/cyrus-mail/cyrus-sasl-${PV}.tar.gz \
	   file://berkdb.m4.patch;patch=1"

inherit autotools 

acpaths = "-I ${S}/cmulocal -I ${S}/config -I ."
CFLAGS_append = " -I${S}/include -I${S}/saslauthd/include"
EXTRA_OECONF = "--enable-shared --enable-static --with-dblib=berkeley \
	        --with-bdb-libdir=${STAGING_LIBDIR} \
	        --with-bdb-incdir=${STAGING_INCDIR}/db4 \
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

do_stage () {
	oe_libinstall -so -a -C lib libsasl2 ${STAGING_LIBDIR}
	install -d ${STAGING_LIBDIR}/sasl2
	install -d ${STAGING_INCDIR}/sasl
	install -m 0644 ${S}/include/hmac-md5.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/md5.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/md5global.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/sasl.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/saslplug.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/saslutil.h ${STAGING_INCDIR}/sasl/
	install -m 0644 ${S}/include/prop.h ${STAGING_INCDIR}/sasl/
}
