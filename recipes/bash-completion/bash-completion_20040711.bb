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


SRC_URI[md5sum] = "90ee706965dbf7b24515220d3bdc1f85"
SRC_URI[sha256sum] = "8e4ddca8aa5ae4261bfcba056292aec4c8bf26fe847e01b67f4b3065fc512a54"
