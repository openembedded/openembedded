SECTION = "console/network"
DEPENDS = "cyrus-sasl"
PR = "r1"
LICENSE = "BSD"

SRC_URI = "ftp://ftp.andrew.cmu.edu/pub/cyrus-mail/OLD-VERSIONS/imap/cyrus-imapd-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
           file://tail.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-auth=unix \
		--without-perl"

BUILD_CFLAGS += " -I${S} -I${S}/et"
#do_compile_prepend () {
#	cd lib
#	ccache arm-linux-gcc -L/home/kergoth/code/build-arm/tmp/staging/arm-linux/lib -Wl,-rpath-link,/home/kergoth/code/build-arm/tmp/staging/arm-linux/lib -o mkchartable mkchartable.o xmalloc.o assert.o
#	${BUILD_CC} ${BUILD_CFLAGS} mkchartable.c -c -o mkchartable.o
#	${BUILD_CC} ${BUILD_CFLAGS} xmalloc.c -c -o xmalloc.o
#	${BUILD_CC} ${BUILD_CFLAGS} assert.c -c -o assert.o
#	${BUILD_CC} ${BUILD_LDFLAGS} -o mkchartable mkchartable.o xmalloc.o assert.o
#	rm -f xmalloc.o assert.o mkchartable.o
#	cd ..
#}
