DESCRIPTION = "Cdump tool from abiword - needed for building abiword"
inherit native

S = "${WORKDIR}/abiword-2.0.12/"
SRC_URI = "file://abiword-2.0.12/cdump.c"

do_compile() {
       gcc -o cdump cdump.c
}

do_stage() {
	install -m 755 cdump ${STAGING_BINDIR}
}

do_install() {
	true
}
