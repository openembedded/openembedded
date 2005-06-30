include elfkickers_${PV}.bb
inherit native

ELFPKGS = "sstrip"
FILESPATH = "${FILE_DIRNAME}/elfkickers-${PV}:${FILE_DIRNAME}/elfkickers:${FILE_DIRNAME}/files"

do_stage () {
	for d in ${ELFPKGS}; do
		install -m 0755 $d/$d ${bindir}/ || exit 1
	done
}
