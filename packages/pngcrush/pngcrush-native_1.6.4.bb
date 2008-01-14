require pngcrush_${PV}.bb

inherit native

S = "${WORKDIR}/pngcrush-${PV}"

do_stage() {
        install -m 755 ${S}/pngcrush ${STAGING_BINDIR}/
}
