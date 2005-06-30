SECTION = "console/network"
include cetools_${PV}.bb
inherit native

do_stage() {
	install -m 0755 rom2files rom2bin bin2rom dump2bin ${STAGING_BINDIR}
}
