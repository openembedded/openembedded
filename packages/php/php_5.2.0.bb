SECTION = "console/network"
DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
LICENSE = "PHP"
DEPENDS = "zlib libxml2 mysql virtual/libiconv php-native"

SRC_URI = "http://us2.php.net/distributions/php-${PV}.tar.bz2\
	       	file://autotools.patch;patch=1 \
		file://acinclude-xml2-config.patch;patch=1 \
                file://pear-makefile.patch;patch=1 \
	 "
S = "${WORKDIR}/php-${PV}"
PR = "r1"

inherit autotools

export THREADS="pthread"
export LIBS=" -lpthread "

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"
EXTRA_OECONF = "    --without-iconv \
 		    --enable-discard-path \
		    --enable-sockets \
    		    --enable-memory-limit \
    		    --enable-wddx \
                    --enable-embedded-mysqli \
                    --enable-magic-quotes \
    		    --with-zlib \
                    --with-mysql="${STAGING_DIR}/${TARGET_SYS}" \
                    --with-mysqli="${STAGING_BINDIR_NATIVE}/mysql_config" \
"




# Uncomment the following two lines, and comment the above to enable PEAR
EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR} --with-libxml-dir=${STAGING_BINDIR}"

export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"
export PHP_NATIVE_DIR="${STAGING_BINDIR_NATIVE}"
export PHP_PEAR_PHP_BIN="/usr/bin/php"

acpaths = ""

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
}

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}



PACKAGES = "${PN}-dbg \
            ${PN}-cli \
            ${PN}-pear \
            ${PN}-dev \
            ${PN} \
"


FILES_${PN}-dbg            ="/usr/bin/.debug"

FILES_${PN}-cli            ="/usr/bin/php"

FILES_${PN}-pear            ="/usr/bin/pear* /usr/bin/pecl \
                             /usr/lib/php/PEAR \
                             /usr/lib/php/PEAR.php \
                             /usr/lib/php/System.php /usr/lib/php/peclcmd.php /usr/lib/php/pearcmd.php \
                             /usr/lib/php/.channels  /usr/lib/php/.channels/.alias  \
                             /usr/lib/php/.channels\__uri.reg \
                             /usr/lib/php/.channels\pear.php.net.reg /usr/lib/php/.channels/pecl.php.net.reg \
                             /usr/lib/php/.registry \
                             /usr/lib/php/Archive/Tar.php \
                             /usr/lib/php/Console/Getopt.php /usr/lib/php/OS/Guess.php \
                             /usr/lib/php/.depdb /usr/lib/php/.depdblock /usr/lib/php/.filemap \
                             /usr/lib/php/.lock"


FILES_${PN}-dev            ="/usr/include/php /usr/include/build \
                            /usr/bin/phpize /usr/bin/php-config"

FILES_${PN}                 ="/usr/lib/php"
FILES_${PN}                +="/usr/bin"



RDEPENDS_${PN}-pear         =${PN}
RDEPENDS_${PN}-cli          =${PN}
RDEPENDS_${PN}-dev          =${PN}


