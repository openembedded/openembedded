require kakasi.inc

inherit native

S = "${WORKDIR}/kakasi-${PV}"

do_stage() {
        install src/mkkanwa ${STAGING_BINDIR}
}


