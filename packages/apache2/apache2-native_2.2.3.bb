SECTION = "net"
DEPENDS = "expat pcre"

inherit cross 

PR ="r7"
SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

S = "${WORKDIR}/httpd-${PV}"

do_configure () {
	./configure --with-included-apr --prefix=${prefix}
}

do_stage () {
	install -d ${STAGING_BINDIR}
	cp srclib/pcre/dftables ${STAGING_BINDIR}
	cp server/gen_test_char ${STAGING_BINDIR}
	cp srclib/apr/apr-1-config ${STAGING_BINDIR}
	cp srclib/apr-util/apu-1-config ${STAGING_BINDIR}
	cp support/apxs ${STAGING_BINDIR}
	chmod 755 ${STAGING_BINDIR}/apxs
	mkdir -p ${STAGING_DIR}/build
	cp build/*.mk ${STAGING_DIR}/build
	cat build/config_vars.mk | \
		sed -e '/^prefix/s,staging,staging/${HOST_SYS},' | \
		sed -e '/^includedir/s,/include,/include/apache2,' | \
		sed -e 's,staging/bin,staging/${HOST_SYS}/bin,' > \
			${STAGING_DIR}/build/config_vars.mk
	cp build/instdso.sh ${STAGING_DIR}/build
	cp .libs/httpd ${STAGING_BINDIR}

	(cd srclib/apr/.libs; tar -cf - libapr-*.so* ) |
	  (cd ${STAGING_LIBDIR}; tar -xf - )
	(cd srclib/apr-util/.libs; tar -cf - libaprutil-*.so* ) |
	  (cd ${STAGING_LIBDIR}; tar -xf - )

    	mkdir -p ${STAGING_INCDIR}/apache2
    	cp include/* ${STAGING_INCDIR}/apache2
	cp os/unix/os.h ${STAGING_INCDIR}/apache2
	cp os/unix/unixd.h ${STAGING_INCDIR}/apache2

  	cp support/envvars-std ${STAGING_BINDIR}/envvars
    	chmod 755 ${STAGING_BINDIR}/envvars
}
