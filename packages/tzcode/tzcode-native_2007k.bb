DESCRIPTION = "tzcode, timezone zoneinfo utils -- zic, zdump, tzselect"
PR = "r0"

SRC_URI = "\
  http://bent.latency.net/bent/darcs/zoneinfo-2007k/src/tzcode${PV}.tar.gz \
  http://bent.latency.net/bent/darcs/zoneinfo-2007k/src/tzdata${PV}.tar.gz \
"
S = "${WORKDIR}"

inherit native

do_stage () {
        install -d ${STAGING_BINDIR_NATIVE}
        install -m 755 zic ${STAGING_BINDIR_NATIVE}/
        install -m 755 zdump ${STAGING_BINDIR_NATIVE}/
        install -m 755 tzselect ${STAGING_BINDIR_NATIVE}/
}

do_install () {
        :
}
