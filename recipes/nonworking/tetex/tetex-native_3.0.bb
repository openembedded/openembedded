require tetex_${PV}.bb
inherit native
DEPENDS = ""
PR = "r2"

PACKAGES=""
RRECOMMENDS_${PN}=""

do_configure() {
	oe_runconf
}

BINARIES = "texk/web2c/tangle \
            texk/web2c/ctangle \
            texk/web2c/otangle \
            texk/web2c/tie \
            utils/texinfo/info/makedoc \
            utils/texinfo/makeinfo/makeinfo"

do_stage() {
	for binary in ${BINARIES}
	do
		install -m 0755 $binary ${STAGING_BINDIR}
	done
}

do_install () {
	:
}


do_rm_work () {
        :
}	


SRC_URI[md5sum] = "944a4641e79e61043fdaf8f38ecbb4b3"
SRC_URI[sha256sum] = "9c0f7eaeb5ba6dc6f66433404d264941bf95cded2fa798b1f7a9dd580c21649b"
