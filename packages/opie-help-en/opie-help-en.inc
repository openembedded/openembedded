DESCRIPTION = "Opie Help Packages - English"
SECTION = "opie/help"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
ALLOW_EMPTY = 1

S = "${WORKDIR}/html"

do_install() {
        install -d ${D}${palmtopdir}/help/en/html/
        install -m 0644 ${WORKDIR}/html/*.html ${D}${palmtopdir}/help/en/html/
	for d in $(find . -type d | grep -v "CVS\|patch")
	do
		install -d ${D}${palmtopdir}/help/en/html/$d
        	install -m 0644 ${WORKDIR}/html/$d/*.html ${D}${palmtopdir}/help/en/html/$d/
	done
}

python populate_packages_prepend () {
	help_dir = bb.data.expand('${palmtopdir}/help/en/html/', d)
	
	do_split_packages(d, help_dir, file_regex='^(.*)\.html$', output_pattern='opie-%s-help-en', description='Opie Help for %s - English', aux_files_pattern=help_dir + '%s/*')
}
