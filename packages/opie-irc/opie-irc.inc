DESCRIPTION = "The Opie IRC client lets you chat on your favorite IRC server using your handheld computer"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
I18N_FILES = "opieirc.ts"
DEPENDS = "libqtaux2"
APPNAME = "opieirc"
#APPTYPE = "binary"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libopieirc.so* bin/opieirc pics/opieirc apps/Applications/opieirc.desktop help/en/html/opieirc.html help/en/html/opieirc
do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/help/en/html/
        install -m 0644 ${WORKDIR}/help/en/html/opieirc.html ${D}${palmtopdir}/help/en/html/
}

