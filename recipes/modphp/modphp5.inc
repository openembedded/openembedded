SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the apache php module."
LICENSE = "PHP"
RDEPENDS = "apache2"
DEPENDS = "apache2-native apache2 zlib"
SRC_URI = "http://de3.php.net/distributions/php-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	  "

S = "${WORKDIR}/php-${PV}"

inherit autotools

FILES_${PN} = "${libdir}/apache2 /etc"
FILES_${PN}-dbg += "${libdir}/apache2/modules/.debug"

CFLAGS += " -g -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED -I${STAGING_INCDIR_NATIVE}/apache2"

EXTRA_OECONF = "--with-apxs2=${STAGING_BINDIR_NATIVE}/apxs \
                --without-mysql \
		--enable-force-cgi-redirect \
		--disable-cgi \
		--disable-cli \
		--disable-pdo \
		--without-pear \
		--without-iconv \
		--disable-ipv6 \
		--disable-xml \
		--disable-xmlreader \
		--disable-xmlwriter \
		--disable-simplexml \
		--disable-libxml \
		--disable-dom \
                --with-zlib --with-zlib-dir=${STAGING_DIR}${layout_exec_prefix}/.. \
                --with-config-file-path=/etc/php/apache2-php5"

#		--with-libxml-dir=${STAGING_DIR_NATIVE}${layout_exec_prefix} \

# to get postgres support, add it to the DEPENDS above
# and uncomment this line.  similar for mysql
#EXTRA_OECONF += " --with-pgsql=${STAGING_DIR_HOST}${layout_exec_prefix}"

acpaths = ""

#
# override the autotools do_configure, which runs autoconf,
# which breaks everything...
#
do_configure() {
	export PHP_LIBXML_DIR=${STAGING_DIR_NATIVE}${layout_exec_prefix} 
	oe_runconf
}

#
do_install  () {
	install -d ${D}/usr/lib/apache2/modules 
	install -d ${D}/etc/apache2/modules.d 
	install -d ${D}/etc/php/apache2-php5
	install -m 755  libs/libphp5.so ${D}/usr/lib/apache2/modules
	install -m 644  ${FILESDIR}/70_mod_php5.conf ${D}/etc/apache2/modules.d
	cat ${S}/php.ini-dist | \
		sed -e 's,extension_dir = \"\./\",extension_dir = \"/usr/lib/extensions\",' \
		> ${D}/etc/php/apache2-php5/php.ini
}
