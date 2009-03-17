DESCRIPTION = "Programmable Completion for Bash"
SECTION = "console/utils"
RDEPENDS = "bash"
LICENSE = "GPL"

SRC_URI = "http://www.caliban.org/files/bash/bash-completion-${PV}.tar.gz \
	   file://bash_completion.sh"
S = "${WORKDIR}/bash_completion"

do_configure() {
	:
}

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}/profile.d
	install -m 0755 ${WORKDIR}/bash_completion.sh ${D}${sysconfdir}/profile.d
	install -m 0755 bash_completion ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/bash_completion.d/
	install -m 0755 contrib/* ${D}${sysconfdir}/bash_completion.d/
}

