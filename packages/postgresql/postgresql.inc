DESCRIPTION = "PostgreSQL is a powerful, open source relational database system."
HOMEPAGE = "http://www.postgresql.com"
LICENSE = "BSD"
DEPENDS = "zlib readline"

#WARNING: this recipe assumes you have the timezone compiler present in /usr/sbin/zic

SRC_URI = "ftp://ftp-archives.postgresql.org/pub/source/v${PV}/${P}.tar.bz2"

inherit autotools pkgconfig

do_compile_append() {
         cp /usr/sbin/zic ${S}/src/timezone/
}

FILES_${PN}-doc += "${prefix}/doc/"
