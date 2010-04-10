require prboom_${PV}.bb

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

SRC_URI[md5sum] = "ef0abe0aad017514857552434b5c6aaa"
SRC_URI[sha256sum] = "200d3c50b082ae46be8c014bb576b4e2d23b1704508fd528c47e3e2b3b04759e"
