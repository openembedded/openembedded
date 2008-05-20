DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
HOMEPAGE = "http://www.php.net"
SECTION = "console/network"
LICENSE = "PHP"
DEPENDS = "zlib libxml2 mysql mysql-native virtual/libiconv php-native"

SRC_URI =     "http://us2.php.net/distributions/php-${PV}.tar.bz2\
               file://acinclude-xml2-config.patch;patch=1"

inherit autotools

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"
EXTRA_OECONF = "--with-cgi --enable-sockets --enable-pcntl \
                --with-mysql \
                --with-zlib --with-zlib-dir=${STAGING_LIBDIR}/.. \
                --without-libpng --without-libjpeg \
                --with-config-file-path=${sysconfdir}/php4"

EXTRA_OECONF += " --without-pear"
# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR_NATIVE}/php"
#DEPENDS += " php-native"

acpaths = ""

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}
