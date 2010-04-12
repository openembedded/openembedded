require regina-rexx_${PV}.bb
inherit native
DEPENDS = ""

do_compile() {
	oe_runmake CEXTRA='-DREGINA_SHARE_DIRECTORY=\"$(sharedir)\"'
}

do_stage_append() {
	install -m 0644 ./msgcmp ${STAGING_BINDIR}/msgcmp-multi-input
}


SRC_URI[md5sum] = "600da451b706c4f24451299e348da555"
SRC_URI[sha256sum] = "74f1521cc613855d26881c7b46fe72b59dafdf377cf26ec9d4f064979039a27f"
