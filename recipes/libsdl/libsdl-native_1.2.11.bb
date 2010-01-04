require ${PN}.inc
PR = "${INC_PR}.1"

SRC_URI_append = "\
	   file://acinclude.m4 \
	   file://kernel-asm-page.patch;patch=1 "

do_configure_prepend() {
	rm -f ${S}/acinclude.m4
	cp ${WORKDIR}/acinclude.m4 ${S}/
}
