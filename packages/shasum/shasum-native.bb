require shasum.inc

inherit native

INHIBIT_DEFAULT_DEPS = "1"
INHIBIT_PATCH_TOOL   = "1"

do_fetch[depends] = ""
do_populate_staging() {
    install ${S}/oe_sha256sum ${STAGING_BINDIR}
}
