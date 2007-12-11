DESCRIPTION = "Squid is a caching proxy for the Web supporting HTTP, HTTPS, FTP, and more"
LICENSE = "GPLv2"

DEPENDS = "squid-native-${PV}"

SRC_URI = "http://www.squid-cache.org/Versions/v2/2.6/squid-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--disable-epoll --disable-nls"

do_configure_append() {
   sed -i -e 's|./cf_gen |${STAGING_BINDIR_NATIVE}/cf_gen |g' src/Makefile
}

# this packages the languages better and saves some space, installs
# English as errors default and the others in locale package

FILES_${PN} += " ${datadir}/errors/English/* \
                 ${datadir}/icons/* \
                 ${datadir}/mib.txt"

FILES_${PN}-locale += " ${datadir}/errors/* " 
