DESCRIPTION = "Timezone data"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/root"
S = "${WORKDIR}/root"

do_install() {
	install -d ${D}/usr/share/
	cp -fa usr/share/zoneinfo ${D}/usr/share/
	find ${D}/usr/share -name "CVS"|xargs rm -rf
}

python populate_packages_prepend() {
        pkgregex = "^(.*)"
        pkgpattern = "timezones-%s"
        pkgdescription = "Timezone for %s"

        do_split_packages(d, root='/usr/share/zoneinfo/', file_regex=pkgregex, output_pattern=pkgpattern, 
                          description=pkgdescription,allow_dirs=True )
}

FILES_${PN} =  "${datadir}/zoneinfo/America/Denver      \
                ${datadir}/zoneinfo/America/NewYork     \
                ${datadir}/zoneinfo/America/LosAngeles  \
                ${datadir}/zoneinfo/Australia/Brisbane  \
                ${datadir}/zoneinfo/Europe/Berlin       \
                ${datadir}/zoneinfo/Asia/Tokyo          "
