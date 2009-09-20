DESCRIPTION = "tzcode, timezone zoneinfo utils -- zic, zdump, tzselect"
INC_PR = "r1"

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
