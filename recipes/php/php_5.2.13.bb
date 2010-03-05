require php.inc

DEPENDS = "zlib libxml2 virtual/libiconv php-native lemon-native mysql5 \
           libc-client openssl"

PR = "r4"

SRC_URI += "file://pear-makefile.patch;patch=1 \
            file://imap-fix-autofoo.patch;patch=1 \
            "
SRC_URI[src.md5sum] = "eb4d0766dc4fb9667f05a68b6041e7d1"
SRC_URI[src.sha256sum] = "2b50a2535e3bb9a98cd4d1633f9452d877276c40b385915261f040d535c7eadb"

export THREADS="pthread"
export LIBS=" -lpthread "

EXTRA_OECONF = "    --without-iconv \
                    --enable-mbstring \
                    --enable-discard-path \
                    --enable-sockets \
                    --enable-shared \
                    --enable-pcntl \
                    --enable-memory-limit \
                    --enable-wddx \
                    --disable-embedded-mysqli \
                    --enable-magic-quotes \
                    --enable-fastcgi \
                    --with-imap=${STAGING_DIR_HOST} \
                    --with-imap-ssl=${STAGING_DIR_HOST} \
                    --with-zlib --with-zlib-dir=${STAGING_LIBDIR}/.. \
                    --with-libxml-dir=${STAGING_BINDIR_CROSS} \
                    --with-mysql="${STAGING_DIR_TARGET}${layout_exec_prefix}" \
                    --with-mysqli="${STAGING_BINDIR_CROSS}/mysql_config" \
                    --with-pdo-mysql="${STAGING_BINDIR_CROSS}/mysql_config" \
                    --without-pdo-sqlite \
               "

export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"
export PHP_NATIVE_DIR = "${STAGING_BINDIR_NATIVE}"
export PHP_PEAR_PHP_BIN = "${bindir}/php"

#LDFLAGS += "-lstdc++"

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
}

# fixme
do_install_append() {
    mv ${D}/${STAGING_DIR_NATIVE}/${sysconfdir} ${D}/${sysconfdir}
    rm -rf ${D}/${STAGING_DIR_NATIVE}
    rm -rf ${D}/.registry
    rm -rf ${D}/.channels
    rm -rf ${D}/.[a-z]*
}

PACKAGES = "${PN}-dbg \
            ${PN}-cli \
            ${PN}-cgi \
            ${PN}-pear \
            ${PN}-dev \
            ${PN}-doc \
            ${PN} \
"


FILES_${PN}-dbg            =+ "${bindir}/.debug"

FILES_${PN}-doc            += "${libdir}/php/doc" 

FILES_${PN}-cli            = "${bindir}/php"
FILES_${PN}-cgi            = "${bindir}/php-cgi"

FILES_${PN}-pear            = "${bindir}/pear* ${bindir}/pecl \
                             ${libdir}/php/PEAR \
                             ${libdir}/php/PEAR.php \
                             ${libdir}/php/System.php ${libdir}php/peclcmd.php ${libdir}/php/pearcmd.php \
                             ${libdir}/php/.channels  ${libdir}/php/.channels/.alias  \
                             ${libdir}/php/.channels\__uri.reg \
                             ${libdir}/php/.channels\pear.php.net.reg ${libdir}/php/.channels/pecl.php.net.reg \
                             ${libdir}/php/.registry \
                             ${libdir}/php/Archive/Tar.php \
                             ${libdir}/php/Console/Getopt.php ${libdir}/php/OS/Guess.php \
                             ${sysconfdir}/pear.conf"


FILES_${PN}-dev            = "${includedir}/php ${libdir}/build \
                             ${bindir}/phpize ${bindir}/php-config \
                             ${libdir}/php/.depdb ${libdir}/php/.depdblock ${libdir}/php/.filemap ${libdir}/php/.lock \
                             ${libdir}/php/test "

FILES_${PN}                 = "${libdir}/php"
FILES_${PN}                += "${bindir}"

RDEPENDS_${PN}-pear         = ${PN}
RDEPENDS_${PN}-cli          = ${PN}
RDEPENDS_${PN}-dev          = ${PN}
