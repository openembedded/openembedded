require git.inc
DEPENDS = "openssl curl"
RDEPENDS = "perl perl-module-file-path cpio findutils"

PR="r1"

do_install() {
	oe_runmake install DESTDIR="${D}" bindir="${bindir}" \
		template_dir="${datadir}/git-core/templates" \
		GIT_PYTHON_DIR="${datadir}/git-core/python"
}
