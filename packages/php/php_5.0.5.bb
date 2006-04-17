SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "PHP"
DEPENDS = "zlib libxml2 mysql"
SRC_URI = "http://de3.php.net/distributions/php-${PV}.tar.bz2 \
           file://autotools.patch;patch=1 \
           file://endianness.patch;patch=1"
S = "${WORKDIR}/php-${PV}"

inherit autotools

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"
EXTRA_OECONF = "--with-cgi --enable-sockets --enable-pcntl \
                --with-mysql=${STAGING_LIBDIR}/.. \
                --with-zlib --with-zlib-dir=${STAGING_LIBDIR}/.. \
                --without-libpng --without-libjpeg \
                --with-config-file-path=${sysconfdir}/php5 \
    --cache-file=config.cache \
    --disable-debug \
    --disable-rpath \
    --enable-bcmath \
    --enable-calendar \
    --enable-maintainer-zts \
    --enable-embed=shared \
    --enable-force-cgi-redirect \
    --enable-ftp \
    --enable-inline-optimization \
    --enable-magic-quotes \
    --enable-memory-limit \
    --enable-pic \
    --enable-safe-mode \
    --enable-sockets \
    --enable-track-vars \
    --enable-trans-sid \
    --enable-wddx \
    --sysconfdir=/etc/appWeb \
    --with-exec-dir=/etc/appWeb/exec \
    --with-db \
    --with-regex=system \
    --with-pear \
    --with-xml \
    --with-xmlrpc \
    --with-zlib \
    --without-iconv"

EXTRA_OECONF += " --without-pear"
# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR}/php"
#DEPENDS += " php-native"

acpaths = ""

do_configure_prepend() {
	find ${S} -type f | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:'
}

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}
