SECTION = "net"
DEPENDS = "expat pcre"

inherit native 

PR = "r0"
SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

S = "${WORKDIR}/httpd-${PV}"

do_configure () {
	./configure --with-included-apr --prefix=${prefix}
}

do_install () {
	install -d ${D}${bindir} ${D}${libdir}
	cp server/gen_test_char ${D}${bindir}
	cp srclib/apr/apr-1-config ${D}${bindir}
	cp srclib/apr-util/apu-1-config ${D}${bindir}
	cp support/apxs ${D}${bindir}
	chmod 755 ${D}${bindir}/apxs
	install -d ${D}/usr/build
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

NATIVE_INSTALL_WORKS = "1"

SRC_URI[md5sum] = "16eadc59ea6b38af33874d300973202e"
SRC_URI[sha256sum] = "868af11e3ed8fa9aade15241ea4f51971b3ef71104292ca2625ef2065e61fb04"
