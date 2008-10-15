DESCRIPTION = "ipkg orphan package list"
AUTHOR = "Alessandro Iurlano <alessandro.iurlano@gmail.com>"
HOMEPAGE = "aiurlano.netsons.org"
SECTION = "console/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ipkg"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/ipkgorphan/ipkgorphan/tags;module=${PV};rev=HEAD;proto=svn"
S = "${WORKDIR}/${PV}"

LDFLAGS += "-lipkg"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/ipkgorphan ${D}${bindir}
}
