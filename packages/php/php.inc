SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "PHP"
SRC_URI = "http://de3.php.net/distributions/php-${PV}.tar.bz2 \
           file://${FILESDIR}/autotools.patch;patch=1 \
           file://${FILESDIR}/pear.patch;patch=1"
S = "${WORKDIR}/php-${PV}"

inherit autotools

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"
EXTRA_OECONF = "--with-cgi --enable-sockets --enable-pcntl \
                --with-mysql \
                --with-zlib --with-zlib-dir=${STAGING_LIBDIR}/.. \
                --without-libpng --without-libjpeg \
                --with-config-file-path=${sysconfdir}/php4"

EXTRA_OECONF += " --without-pear"
# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR}/php"
#DEPENDS += " php-native"

acpaths = ""

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}
