SECTION = "console/utils"
inherit native
include unzip_${PV}.bb

do_stage() {
	install -d ${STAGING_BINDIR}
	install unzip ${STAGING_BINDIR}
}
