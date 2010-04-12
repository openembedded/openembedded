require zip_${PV}.bb

inherit native

S = "${WORKDIR}/zip-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install zip zipnote zipsplit zipcloak ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "8a4da4460386e324debe97f3b7fe4d96"
SRC_URI[sha256sum] = "d0d3743f732a9baa162f80d0c4567b9c545b41a3385825042113810f2a56eb2f"
