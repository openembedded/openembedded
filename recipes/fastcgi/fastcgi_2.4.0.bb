LICENSE = "Open Market"
DESCRIPTION = "Fast CGI backend (web server to CGI handler) library"
PR = "r4"

SRC_URI = "http://www.fastcgi.com/dist/fcgi-${PV}.tar.gz \
file://link-against-math.patch;patch=1 \
file://cstdio.patch;patch=1 "

S=${WORKDIR}/fcgi-${PV}

LEAD_SONAME = "libfcgi.so*"

PARALLEL_MAKE=""

inherit autotools pkgconfig

SRC_URI[md5sum] = "d15060a813b91383a9f3c66faf84867e"
SRC_URI[sha256sum] = "66fc45c6b36a21bf2fbbb68e90f780cc21a9da1fffbae75e76d2b4402d3f05b9"
