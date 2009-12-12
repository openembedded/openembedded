SECTION = "net"
DEPENDS = "expat pcre"

inherit native 

PR ="r1"
SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

S = "${WORKDIR}/httpd-${PV}"

do_configure () {
	./configure --with-included-apr --prefix=${prefix}
}

do_stage () {
	install -d ${STAGING_BINDIR_NATIVE}
	cp server/gen_test_char ${STAGING_BINDIR_NATIVE}
	cp srclib/apr/apr-1-config ${STAGING_BINDIR_NATIVE}
	cp srclib/apr-util/apu-1-config ${STAGING_BINDIR_NATIVE}
	cp support/apxs ${STAGING_BINDIR_NATIVE}
	chmod 755 ${STAGING_BINDIR_NATIVE}/apxs
	mkdir -p ${STAGING_DIR_NATIVE}//usr/build
	cp build/*.mk ${STAGING_DIR_NATIVE}/usr/build
	cp build/instdso.sh ${STAGING_DIR_NATIVE}/usr/build
	cp .libs/httpd ${STAGING_BINDIR_NATIVE}

	(cd srclib/apr/.libs; tar -cf - libapr-*.so* ) |
	  (cd ${STAGING_LIBDIR_NATIVE}; tar -xf - )
	(cd srclib/apr-util/.libs; tar -cf - libaprutil-*.so* ) |
	  (cd ${STAGING_LIBDIR_NATIVE}; tar -xf - )

	mkdir -p ${STAGING_INCDIR_NATIVE}/apache2
	cp include/* ${STAGING_INCDIR_NATIVE}/apache2
	cp os/unix/os.h ${STAGING_INCDIR_NATIVE}/apache2
	cp os/unix/unixd.h ${STAGING_INCDIR_NATIVE}/apache2

  	cp support/envvars-std ${STAGING_BINDIR_NATIVE}/envvars
    	chmod 755 ${STAGING_BINDIR_NATIVE}/envvars
}
