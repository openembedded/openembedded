DESCRIPTION = "Timezone data"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=v1_2_0;module=opie/root"
S = "${WORKDIR}/root"

do_install() {
	install -d ${D}${datadir}/
	cp -fa usr/share/zoneinfo ${D}${datadir}/
	find ${D}${datadir} -name "CVS"|xargs rm -rf
}

PACKAGES_DYNAMIC = "timezone-*"

python populate_packages_prepend() {
        pkgregex = "^(.*)"
        pkgpattern = "timezone-%s"
        pkgdescription = "Timezone for %s"

        do_split_packages(d, root=bb.data.expand('${datadir}/zoneinfo/', d), file_regex=pkgregex, output_pattern=pkgpattern, 
                          description=pkgdescription,allow_dirs=True )
}

FILES_${PN} =  "${datadir}/zoneinfo/America/Denver      \
                ${datadir}/zoneinfo/America/New_York    \
                ${datadir}/zoneinfo/America/Los_Angeles \
                ${datadir}/zoneinfo/Australia/Brisbane  \
                ${datadir}/zoneinfo/Europe/Berlin       \
                ${datadir}/zoneinfo/Asia/Tokyo          "
