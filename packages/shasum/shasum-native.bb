require shasum.inc

inherit native

do_populate_staging() {
    install ${S}/sha256sum ${STAGING_BINDIR}
}
