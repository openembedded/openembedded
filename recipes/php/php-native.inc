require php.inc

DEPENDS = "zlib-native libxml2-native"

inherit autotools native pkgconfig
export LIBS=" -lxml2 "
export LD_LIBRARY_PATH = "${STAGING_LIBDIR_NATIVE}"

EXTRA_OECONF = "--with-cgi --enable-sockets --enable-pcntl \
                --with-zlib --with-zlib-dir=${STAGING_LIBDIR_NATIVE}/.. \
                --without-libpng --without-libjpeg \
                --with-libxml-dir=${STAGING_BINDIR_NATIVE} \
               "
