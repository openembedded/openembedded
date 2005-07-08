DESCRIPTION = "Dreambox DM7020 second stage bootloader"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV = "28"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${PV}-${PR}.bin"

S = "${WORKDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	gzip -c ${S}/secondstage-${PV}-${PR}.bin > ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}

