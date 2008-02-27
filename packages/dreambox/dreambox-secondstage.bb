DESCRIPTION = "Dreambox DM702x second stage bootloader"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV_dm7020 = "35"
PV_dm7025 = "51"
PV_dm600pvr = "53"
PV_dm500plus = "53"
PV_dm8000 = "53"
PV_dm800 = "57"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

S = "${WORKDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	gzip -c ${S}/secondstage-${MACHINE}-${PV}.bin > ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}

# the dm800 secondstage is already compressed (and encrypted)
do_stage_dm800() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	cp ${S}/secondstage-${MACHINE}-${PV}.bin ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}
