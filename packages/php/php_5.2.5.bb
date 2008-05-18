require php.inc

PR = "r3"

SRC_URI += "file://pear-makefile.patch;patch=1 "

export THREADS="pthread"
export LIBS=" -lpthread "

EXTRA_OECONF = "    --without-iconv \
 		    --enable-discard-path \
		    --enable-sockets \
    		    --enable-memory-limit \
    		    --enable-wddx \
                    --enable-embedded-mysqli \
                    --enable-magic-quotes \
    		    --with-zlib \
                    --with-mysql="${STAGING_DIR_TARGET}${layout_exec_prefix}" \
                    --with-mysqli="${STAGING_BINDIR_NATIVE}/mysql_config" \
"

EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR} --with-libxml-dir=${STAGING_BINDIR_CROSS}"

export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"
export PHP_NATIVE_DIR="${STAGING_BINDIR_NATIVE}"
export PHP_PEAR_PHP_BIN="/usr/bin/php"

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
}

PACKAGES = "${PN}-dbg \
            ${PN}-cli \
            ${PN}-pear \
            ${PN}-dev \
            ${PN} \
"


FILES_${PN}-dbg            =+"/usr/bin/.debug"

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
