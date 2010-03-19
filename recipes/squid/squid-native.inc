inherit native autotools

SRC_URI = "http://www.squid-cache.org/Versions/v2/${SQUID_MAJOR}/squid-${PV}.tar.bz2;name=squid-${PV}"
S = "${WORKDIR}/squid-${PV}"

do_stage() {
        install -d ${STAGING_BINDIR_NATIVE}   
        install -m 0755 src/cf_gen ${STAGING_BINDIR_NATIVE}/cf_gen
}
