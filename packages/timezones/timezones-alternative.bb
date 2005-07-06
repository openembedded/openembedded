DESCRIPTION = "Timezone data, alternative"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"

SRC_URI = "http://sources.dreamboxupdate.com/zoneinfo.tar.bz2"
S = "${WORKDIR}/zoneinfo"

do_install() {
	install -d ${D}/usr/share/zoneinfo/
	
	for file in ${S}/*
	do
		install -m 644 "$file" ${D}/usr/share/zoneinfo/
	done
}

FILES_${PN} = "usr/share/zoneinfo/[A-Z]*"
