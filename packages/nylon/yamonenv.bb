DESCRIPTION = "Reads YAMON environment-variables"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael Stickel <michael.stickel@4g-systems.biz>"
LICENSE = "GPL"
PV = "cvs${CVSDATE}"

SRC_URI = "svn://meshcube.org/svn/application;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 ${S}/src/yamonenv ${D}${sbindir}
}
