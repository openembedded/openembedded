include prboom_${PV}.bb

PR = "r6"

S = "${WORKDIR}/prboom-${PV}"

SRC_URI_append = " file://prboom.png \
                   file://prboom.desktop \
		   file://prboom.sh "



do_install_append() {
        install -d ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/pics \

	install -m 0755 ${WORKDIR}/prboom.sh ${D}${bindir}
	install -m 0644 ${WORKDIR}/prboom.png ${D}${palmtopdir}/pics/prboom.png
	install -m 0644 ${WORKDIR}/prboom.desktop ${D}${palmtopdir}/apps/Games/prboom.desktop
}

FILES_${PN}_append = " ${palmtopdir}"
