require nkf_${PV}.bb
inherit native

do_stage() {
    install -m 0755 nkf ${STAGING_BINDIR}
}

do_install() {
	:
}


SRC_URI[md5sum] = "af11dcd3fe71d67831c020e3bfd5073b"
SRC_URI[sha256sum] = "71d2ba992df209a00bb1dca45e3336729dc16e51b71526bd20f897cc6127a275"
