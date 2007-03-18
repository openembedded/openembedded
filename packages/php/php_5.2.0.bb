SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
LICENSE = "PHP"
DEPENDS = "zlib libxml2 mysql libiconv"
SRC_URI = "http://us2.php.net/distributions/php-${PV}.tar.bz2\
	 "

S = "${WORKDIR}/php-${PV}"
PR = "r0"

inherit autotools

export THREADS="pthread"
export LIBS=" -lpthread "

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"

EXTRA_OECONF = "    --without-iconv \
 		    --enable-discard-path \
		    --enable-sockets \
    		    --enable-memory-limit \
    		    --enable-wddx \
    		    --with-zlib"

EXTRA_OECONF += " --without-pear --with-libxml-dir=${STAGING_BINDIR} "
export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"

# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR_NATIVE}/php"
#DEPENDS += " php-native"

acpaths = ""

do_configure () {
	autoreconf
ac_cv_php_xml2_config_path=${STAGING_BINDIR_CROSS}/xml2-config oe_runconf
}


do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
}

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}

