require php.inc

DEPENDS = "zlib libxml2 virtual/libiconv php-native lemon-native mysql5 \
           libc-client openssl"

PR = "${INC_PR}.0"

SRC_URI =     "http://downloads.php.net/johannes/php-${PV}.tar.gz;name=src \
               file://acinclude-xml2-config.patch \
               file://php-m4-divert.patch \
               file://iconv.patch \
               file://imap-fix-autofoo.patch \
	       file://pear-makefile.patch \
               file://phar-makefile.patch \
               file://php_exec_native.patch \
              "

SRC_URI[src.md5sum] = "fb727a3ac72bf0ce37e1a20468a7bb81"
SRC_URI[src.sha256sum] = "95474df979efbf2b1a298998fe9954200f59048681817a97eb18415346fb6ca4"

export THREADS="pthread"
export LIBS=" -lpthread "

EXTRA_OECONF = "    --enable-mbstring \
                    --enable-discard-path \
                    --enable-sockets \
                    --enable-shared \
                    --enable-pcntl \
                    --enable-wddx \
                    --disable-embedded-mysqli \
                    --disable-rpath \
                    --enable-magic-quotes \
                    --enable-fastcgi \
                    --with-imap=${STAGING_DIR_HOST} \
                    --with-imap-ssl=${STAGING_DIR_HOST} \
                    --with-zlib --with-zlib-dir=${STAGING_LIBDIR}/.. \
                    --with-iconv=${STAGING_LIBDIR}/.. \
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
    find ${S} -type f -readable -writable | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
    # use same fix as libiconv
    sed -i -e  s/^hardcode_libdir_flag_spec/#hardcode_libdir_flag_spec/ \
           -e s/^runpath_var/#runpath_var/ ${S}/*-libtool
}

# fixme
do_install_append() {
    mv ${D}/${STAGING_DIR_NATIVE}/${sysconfdir} ${D}/${sysconfdir}
    rm -rf ${D}/${STAGING_DIR_NATIVE}
    rm -rf ${D}/.registry
    rm -rf ${D}/.channels
    rm -rf ${D}/.[a-z]*
    sed -i 's:${STAGING_DIR_NATIVE}::g' ${D}/${sysconfdir}/pear.conf
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
