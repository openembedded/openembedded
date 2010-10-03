SECTION = "net"
DEPENDS = "expat pcre"

inherit native 

PR = "r11"
SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

S = "${WORKDIR}/httpd-${PV}"

do_configure () {
	./configure --with-included-apr --prefix=${prefix}
}

do_install () {
	install -d ${D}${bindir} ${D}${libdir}
	cp srclib/pcre/dftables ${D}${bindir}
	cp server/gen_test_char ${D}${bindir}
	cp srclib/apr/apr-1-config ${D}${bindir}
	cp srclib/apr-util/apu-1-config ${D}${bindir}
	cp support/apxs ${D}${bindir}
	chmod 755 ${D}${bindir}/apxs
	install -d ${D}//usr/build
	cp build/*.mk ${D}/usr/build
	cp build/instdso.sh ${D}/usr/build
	cp .libs/httpd ${D}${bindir}

	(cd srclib/apr/.libs; tar -cf - libapr-*.so* ) |
	  (cd ${D}${libdir}; tar -xf - )
	(cd srclib/apr-util/.libs; tar -cf - libaprutil-*.so* ) |
	  (cd ${D}${libdir}; tar -xf - )

	install -d ${D}${includedir}/apache2
	cp include/* ${D}${includedir}/apache2
	cp os/unix/os.h ${D}${includedir}/apache2
	cp os/unix/unixd.h ${D}${includedir}/apache2

  	cp support/envvars-std ${D}${bindir}/envvars
    	chmod 755 ${D}${bindir}/envvars
}

SRC_URI[md5sum] = "887bf4a85505e97babe1d90635361c0d"
SRC_URI[sha256sum] = "dd86e8221f9efb85497c46229d0f04237d4e66d293fabe98eb0745166aaf4b6c"

NATIVE_INSTALL_WORKS = "1"
