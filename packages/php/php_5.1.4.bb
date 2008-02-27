require php.inc

PR = "r3"

inherit autotools

export THREADS="pthread"
export LIBS=" -lpthread "

EXTRA_OECONF = "--without-iconv \
 	        --enable-discard-path \
	        --enable-sockets \
    	        --enable-memory-limit \
    	        --enable-wddx \
    	         --with-zlib"

EXTRA_OECONF += " --without-pear --with-libxml-dir=${STAGING_BINDIR} "
# Uncomment the following two lines, and comment the above to enable PEAR
#EXTRA_OECONF += " --with-pear-php-cli=${STAGING_BINDIR_NATIVE}/php"
#DEPENDS += " php-native"

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:'
    find ${S} -type f | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}
