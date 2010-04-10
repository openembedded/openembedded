require ${PN}.inc
PR = "${INC_PR}.1"

SRC_URI_append = "\
	   file://acinclude.m4 \
	   file://kernel-asm-page.patch;patch=1 "

do_configure_prepend() {
	rm -f ${S}/acinclude.m4
	cp ${WORKDIR}/acinclude.m4 ${S}/
}

SRC_URI[md5sum] = "418b42956b7cd103bfab1b9077ccc149"
SRC_URI[sha256sum] = "6985823287b224b57390b1c1b6cbc54cc9a7d7757fbf9934ed20754b4cd23730"
