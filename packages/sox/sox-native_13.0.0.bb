include sox_${PV}.bb

S = "${WORKDIR}/sox-${PV}"

inherit native

do_patch() {
        true
}

do_stage() {
	make bindir="${STAGING_BINDIR}" libdir="${STAGING_LIBDIR}" mandir="${STAGING_DIR}/${HOST_SYS}/man" includedir="${STAGING_INCDIR}" install
	rm ${STAGING_BINDIR}/rec
	ln -s ${STAGING_BINDIR}/play ${STAGING_BINDIR}/rec
}

do_install() {
        true
}
