SECTION = "net"
DEPENDS = "expat pcre"

inherit  native

PR="r4"
SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

S = "${WORKDIR}/httpd-${PV}"

do_configure () {
	./configure --prefix=${prefix}
}

do_populate_staging () {
	cp srclib/pcre/dftables ../../../staging/i686-linux/bin/
	cp server/gen_test_char ../../../staging/i686-linux/bin/
	cp srclib/apr/apr-1-config ../../../staging/i686-linux/bin/
	cp srclib/apr-util/apu-1-config ../../../staging/i686-linux/bin/
	cp support/apxs ../../../staging/i686-linux/bin/
	chmod 755 ../../../staging/i686-linux/bin/apxs
	mkdir -p ../../../staging/build
	cp build/*.mk ../../../staging/build
	cat build/config_vars.mk | \
		sed -e '/^prefix/s,staging,staging/i686-linux,' | \
		sed -e '/^includedir/s,/include,/include/apache2,' | \
		sed -e 's,staging/bin,staging/i686-linux/bin,' > \
			../../../staging/build/config_vars.mk
	cp build/instdso.sh ../../../staging/build
	cp .libs/httpd ../../../staging/i686-linux/bin

	(cd srclib/apr/.libs; tar -cf - libapr-*.so* ) | 
	  (cd ../../../staging/i686-linux/lib; tar -xf - )
	(cd srclib/apr-util/.libs; tar -cf - libaprutil-*.so* ) | 
	  (cd ../../../staging/i686-linux/lib; tar -xf - )

    	mkdir -p ../../../staging/i686-linux/include/apache2
    	cp include/* ../../../staging/i686-linux/include/apache2
	cp os/unix/os.h ../../../staging/i686-linux/include/apache2
	cp os/unix/unixd.h ../../../staging/i686-linux/include/apache2

  	cp support/envvars-std ../../../staging/i686-linux/bin/envvars
    	chmod 755 ../../../staging/i686-linux/bin/envvars
}
