DESCRIPTION = "Developer Examples for Opie"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
DEPENDS = "opie-networksettings"
LICENSE = "GPL"
APPTYPE = "binary"

S = "${WORKDIR}/examples"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/bin/

        for i in `find . -perm 0755 -type f`
        do
                install -m 0755 $i ${D}${palmtopdir}/bin/`basename $i`
        done
}

