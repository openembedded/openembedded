require elfkickers_${PV}.bb
inherit native

ELFPKGS = "sstrip"

do_stage () {
	for d in ${ELFPKGS}; do
		install -m 0755 $d/$d ${bindir}/ || exit 1
	done
}
