SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
MAINTAINER = "Shane Volpe <shanevolpe@gmail.com>"
LICENSE = "PHP"
DEPENDS = "zlib libxml2 mysql libiconv"
SRC_URI = "http://us2.php.net/distributions/php-${PV}.tar.bz2\
	       file://autotools.patch;patch=1"
S = "${WORKDIR}/php-${PV}"
PR = "r1"

inherit autotools

export THREADS="pthread"
export LIBS=" -lpthread "

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"
EXTRA_OECONF = "--without-iconv \
 			    --enable-discard-path \
			    --enable-sockets \
    		    --enable-memory-limit \
    		    --enable-wddx \
    		    --with-zlib"

EXTRA_OECONF += " --without-pear"
# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR}/php"
#DEPENDS += " php-native"

acpaths = ""

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:'
    find ${S} -type f | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}
