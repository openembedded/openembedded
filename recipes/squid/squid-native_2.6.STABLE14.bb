inherit native autotools

SRC_URI = "http://www.squid-cache.org/Versions/v2/2.6/squid-${PV}.tar.bz2"
S = "${WORKDIR}/squid-${PV}"

inherit native autotools

do_stage() {
        install -d ${STAGING_BINDIR_NATIVE}   
        install -m 0755 src/cf_gen ${STAGING_BINDIR_NATIVE}/cf_gen
}
