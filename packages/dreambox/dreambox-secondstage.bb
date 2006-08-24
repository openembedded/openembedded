DESCRIPTION = "Dreambox DM702x second stage bootloader"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV_dm7020 = "35"
PV_dm7025 = "45"
PV_dm600pvr = "44"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

S = "${WORKDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	gzip -c ${S}/secondstage-${MACHINE}-${PV}.bin > ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}
